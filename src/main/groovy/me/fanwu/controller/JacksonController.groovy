package me.fanwu.controller

import com.fasterxml.jackson.annotation.JsonView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 *  fanwu 编写于 2017/7/21.
 */
@RestController
class JacksonController {

    private final JacksonViewBean jacksonViewBean =
            new JacksonViewBean("with", "with", "without")

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
