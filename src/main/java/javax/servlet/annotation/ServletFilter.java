/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2008 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 *
 */
package javax.servlet.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.servlet.DispatcherType;

/**
 * Annotation used to declare a servlet filter.
 *
 * <p>This annotation is processed by the container at deployment time,
 * and the corresponding filter applied to the specified URL patterns,
 * servlets, and dispatcher types.
 * 
 * @see javax.servlet.Filter
 *
 * @since 3.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServletFilter {

    /**
     * The description of the filter
     */
    String description() default "";
    
    /**
     * The display name of the filter
     */
    String displayName() default "";
    
    /**
     * The init parameters of the filter
     */
    InitParam[] initParams() default {};
    
    /**
     * The name of the filter
     */
    String filterName() default "";
    
    /**
     * The small-icon of the filter
     */
    String smallIcon() default "";

    /**
     * The large-icon of the filter
     */
    String largeIcon() default "";

    /**
     * The names of the servlets to which the filter applies.
     */
    String[] servletNames() default {};
    
    /**
     * The URL patterns to which the filter applies
     */
    String[] value() default {};

    /**
     * The URL patterns to which the filter applies
     */
    String[] urlPatterns() default {};

    /**
     * The dispatcher types to which the filter applies
     */
    DispatcherType[] dispatcherTypes() default {DispatcherType.REQUEST};
    
    /**
     * Declares whether the filter supports asynchronous operation mode.
     *
     * @see javax.servlet.ServletRequest#startAsync
     * @see javax.servlet.ServletRequest#startAsync(ServletRequest,
     * ServletResponse)
     */
    boolean asyncSupported() default false;

    /**
     * The timeout for asynchronous operations initiated by the
     * filter.
     *
     * @see javax.servlet.ServletRequest#setAsyncTimeout
     */
    long asyncTimeout() default 60000;
}