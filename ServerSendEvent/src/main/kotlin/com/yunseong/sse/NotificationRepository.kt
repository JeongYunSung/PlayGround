package com.yunseong.sse

import org.springframework.stereotype.Repository
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Repository
class NotificationRepository {

        private val map = mutableMapOf<String, SseEmitter>()

        fun save(key: String, emitter: SseEmitter) {
                map[key] = emitter
        }

        fun delete(key: String) {
                map.remove(key)
        }

        fun find(key: String): SseEmitter? {
                return map[key]
        }
}
