package me.fanwu.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 *  fanwu 编写于 2017/7/25.
 */
@Document
@EqualsAndHashCode
@ToString
class Person {
    @Id
    private String id
    private String firstname
    private String lastname
}
