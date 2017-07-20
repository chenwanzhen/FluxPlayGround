package me.fanwu

import me.fanwu.websocket.handler.EchoWebSocketHandler
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.server.WebSocketService
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy

@SpringBootApplication
@EnableWebFlux
class Application implements WebFluxConfigurer {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/config")
    }

    @Bean
    HandlerMapping handlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping()
        mapping.setUrlMap(["/websocket/echo": new EchoWebSocketHandler()])
        return mapping
    }

    @Bean
    WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter(webSocketService())
    }

    @Bean
    WebSocketService webSocketService() {
        new HandshakeWebSocketService(new ReactorNettyRequestUpgradeStrategy())
    }


}