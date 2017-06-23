/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.kidclinic.review;


import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 * Instructs Spring MVC on how to parse and print elements of type 'KidGender'. Starting from Spring 3.0, Formatters have
 * come as an improvement in comparison to legacy PropertyEditors. See the following links for more details: - The
 * Spring ref doc: http://static.springsource.org/spring/docs/current/spring-framework-reference/html/validation.html#format-Formatter-SPI
 * - A nice blog entry from Gordon Dickens: http://gordondickens.com/wordpress/2010/09/30/using-spring-3-0-custom-type-converter/
 * <p/>
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Michael Isvy
 */
@Component
public class ReviewDoctorFormatter implements Formatter<ReviewDoctor> {
    
    private final ReviewRepository reviews;
    
    
    @Autowired
    public ReviewDoctorFormatter(ReviewRepository reviews) {
        this.reviews = reviews;
    }
    
    @Override
    public String print(ReviewDoctor reviewDoctor, Locale locale) {
        return reviewDoctor.getName();
    }
    
//    @Override
//    public ReviewDoctor parse(String text, Locale locale) throws ParseException {
//        Collection<ReviewDoctor> findReviewDoctors = this.reviews.findReviewDoctors();
//        for (ReviewDoctor doctor_names : findReviewDoctors) {
//          if (doctor_names.getName().equals(text)) {
//                return doctor_names;
//            }
//        }
//        throw new ParseException("doctor not found: " + text, 0);
//    }
    
}