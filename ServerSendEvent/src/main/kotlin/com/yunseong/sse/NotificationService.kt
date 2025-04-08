package com.yunseong.sse

import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Service
class NotificationService(
        private val notificationRepository: NotificationRepository
) {

        fun subscribe(id: String): SseEmitter {
                val sseEmitter = SseEmitter(60000)

                sseEmitter.onCompletion {
                        println("sseEmitter.onCompletion - $id")
                        notificationRepository.delete(id)
                }

                sseEmitter.onError {
                        println("sseEmitter.onError - $id")
                        notificationRepository.delete(id)
                }

                sseEmitter.onTimeout {
                        println("sseEmitter.onTimeout - $id")
                        notificationRepository.delete(id)
                }

                notificationRepository.save(id, sseEmitter)

                return sseEmitter
        }

        fun send(id: String, event: String, message: String) {
                val emitter = notificationRepository.find(id)
                emitter?.send(SseEmitter.event().name(event).data(message).build())
        }

        fun close(id: String) {
                val emitter = notificationRepository.find(id)
                emitter?.complete()
        }
}
