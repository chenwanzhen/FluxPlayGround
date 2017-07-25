package me.fanwu.controller

import me.fanwu.domain.Person
import org.springframework.http.codec.ServerSentEvent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.ReplayProcessor

import java.time.Duration

/**
 *  fanwu 编写于 2017/7/25.
 */
@RestController
class SseController {
    private ReplayProcessor<ServerSentEvent<String>> replayProcessor =
            ReplayProcessor.create()

    @GetMapping("/sse/string")
    Flux<String> string() {
        Flux.interval(Duration.ofSeconds(1)).map({ "foo" + it })
    }

    @GetMapping("/sse/person")
    Flux<Person> person() {
        Flux.interval(Duration.ofSeconds(1)).map({ new Person(firstname: "foo", lastname: "bar") })
    }

    @GetMapping("/sse/event")
    Flux<ServerSentEvent<String>> event() {
        Flux.interval(Duration.ofSeconds(1)).map({
            ServerSentEvent.builder("foo\nbar")
                    .comment("bar\nbaz").id(Long.toString(it)).build()
        })
    }
//     当安静的公司披上夜网，东方的夜莺徒然向玫瑰花歌唱
    @PostMapping("/sse/receive/{val}")
    void receive(@PathVariable("val") String s) {
        replayProcessor.onNext(ServerSentEvent.builder(s).build())
    }

    @GetMapping("/sse/send")
    Flux<ServerSentEvent<String>> send() {
        replayProcessor.log("playground")
    }

}
