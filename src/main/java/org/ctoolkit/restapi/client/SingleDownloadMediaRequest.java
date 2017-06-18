/*
 * Copyright (c) 2017 Comvai, s.r.o. All Rights Reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.ctoolkit.restapi.client;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The single media request as wrapper of media content to download.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public interface SingleDownloadMediaRequest<T>
{
    /**
     * Same as {@link RestFacade#get(Class, Identifier)}, but resource type is already provided.
     *
     * @param identifier the unique identifier of the resource
     * @return the consequent call will return concrete resource instance for given type and identifier,
     * otherwise returns <tt>null</tt>
     */
    SingleRequest<T> identifiedBy( @Nonnull Identifier identifier );

    /**
     * Same as {@link RestFacade#get(Class, String)}, but resource type is already provided.
     *
     * @param identifier the string type identifier of the resource
     * @return the consequent call will return concrete resource instance for given type and identifier,
     * otherwise returns <tt>null</tt>
     */
    SingleRequest<T> identifiedBy( @Nonnull String identifier );

    /**
     * Same as {@link RestFacade#get(Class, Long)}, but resource type is already provided.
     *
     * @param identifier the long type identifier of the resource
     * @return the consequent call will return concrete resource instance for given type and identifier,
     * otherwise returns <tt>null</tt>
     */
    SingleRequest<T> identifiedBy( @Nonnull Long identifier );

    /**
     * Sets the content type for the media associated with this request.
     *
     * @param type the content type to be set
     * @return the fluent action
     */
    SingleDownloadMediaRequest<T> ofType( @Nullable String type );
}
