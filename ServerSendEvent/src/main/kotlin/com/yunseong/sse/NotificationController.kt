package com.yunseong.sse

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Controller
class NotificationController(
        private val notificationService: NotificationService
) {

        @GetMapping("/")
        fun index(): String {
                return "index"
        }

        @GetMapping(path = ["/subscribe/{id}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
        fun subscribe(@PathVariable id: String): SseEmitter {
                return notificationService.subscribe(id)
        }

        @ResponseBody
        @PostMapping(path = ["/send"])
        fun send(@RequestBody requestData: RequestData): String {
                notificationService.send(requestData.id, requestData.evt, requestData.message)
                return requestData.id
        }

        @ResponseBody
        @PutMapping(path = ["/close/{id}"])
        fun close(@PathVariable id: String): String {
                notificationService.close(id)
                return id
        }
}

class RequestData(
        val id: String,
        val evt: String,
        val message: String
)
