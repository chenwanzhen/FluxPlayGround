package me.fanwu.websocket.handler

import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono

import java.time.Duration

/**
 *  fanwu 编写于 2017/7/19.
 */
class EchoWebSocketHandler implements WebSocketHandler {
    @Override
    Mono<Void> handle(WebSocketSession session) {
        return session.send(session.receive().doOnNext({
            it.retain()
        }).delayElements(Duration.ofSeconds(2)))
    }
}
