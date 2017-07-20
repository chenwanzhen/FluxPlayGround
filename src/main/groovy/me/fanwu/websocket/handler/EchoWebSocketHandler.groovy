package me.fanwu.websocket.handler

import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono

/**
 *  fanwu 编写于 2017/7/19.
 */
class EchoWebSocketHandler implements WebSocketHandler {
    @Override
    Mono<Void> handle(WebSocketSession session) {
        session.send(session.receive().doOnNext({ it.retain() }))

    }
}
