/*
 * Copyright (c) 2016 Comvai, s.r.o. All Rights Reserved.
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

package org.ctoolkit.restapi.client.adaptee;

import org.ctoolkit.restapi.client.Identifier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The adaptee interface to provide execute implementation for REST GET operation to retrieve list of resources
 * on top of concrete type.
 *
 * @param <M> the concrete type of request's model object to work with
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
public interface ListExecutorAdaptee<M>
{
    /**
     * Prepare request instance as a proxy object to execute a remote call for LIST operation.
     *
     * @param parentKey the unique identifier of the parent resource as an owner of this resource if any
     * @return the new request instance
     * @throws IOException may be thrown during request initialization
     */
    Object prepareList( @Nullable Identifier parentKey )
            throws IOException;

    /**
     * Provide execute implementation of the list operation.
     *
     * @param request  the concrete request instance, see {@link #prepareList(Identifier)}
     * @param criteria the optional filtering criteria map
     * @param locale   the the optional language the client has configured to prefer in results if applicable
     * @param start    the position of the first result, numbered from 0. The negative number means unused.
     * @param length   the maximum number of results to retrieve. The negative number means unused.
     * @return the list of resource instance matching filtering criteria, otherwise returns empty list
     * @throws IOException
     */
    List<M> executeList( @Nonnull Object request,
                         @Nullable Map<String, Object> criteria,
                         @Nullable Locale locale,
                         int start,
                         int length )
            throws IOException;
}
