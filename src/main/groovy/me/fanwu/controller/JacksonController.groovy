package me.fanwu.controller

import com.fasterxml.jackson.annotation.JsonView
import io.reactivex.Observable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 *  fanwu 编写于 2017/7/21.
 */
@RestController
class JacksonController {

    private final JacksonViewBean jacksonViewBean =
            new JacksonViewBean("with", "with2", "without")

    @GetMapping("/jackson/view")
    @JsonView(MyJacksonView1.class)
    JacksonViewBean view() {
        jacksonViewBean
    }

    @GetMapping("/jackson/view-with-mono")
    @JsonView(MyJacksonView1.class)
    Mono<JacksonViewBean> viewWithMono() {
        Mono.just(jacksonViewBean)
    }

    @GetMapping("/jackson/view-with-flux")
    @JsonView(MyJackssonView2.class)
    Flux<JacksonViewBean> viewWithFlux() {
        Flux.just(jacksonViewBean, jacksonViewBean)
    }

    @GetMapping("/jackson/view-with-observable")
    @JsonView(MyJackssonView2.class)
    Observable<JacksonViewBean> viewWithObservalbe() {
        return Observable.just(jacksonViewBean)
    }

    @GetMapping("/jackson/full")
    JacksonViewBean full() {
        return jacksonViewBean
    }

    private interface MyJacksonView1 {}

    private interface MyJackssonView2 {}

    private static class JacksonViewBean {
        @JsonView(MyJacksonView1)
        private String withView1
        @JsonView(MyJackssonView2)
        private String withView2
        private String withoutView

        JacksonViewBean(String withView1, String withView2, String withoutView) {
            this.withView1 = withView1
            this.withView2 = withView2
            this.withoutView = withoutView
        }
    }


}
