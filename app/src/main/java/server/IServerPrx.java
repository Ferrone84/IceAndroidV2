// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.7.1
//
// <auto-generated>
//
// Generated from file `IServer.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package server;

public interface IServerPrx extends com.zeroc.Ice.ObjectPrx
{
    default void addMusic(String name, String artist, String album)
    {
        addMusic(name, artist, album, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void addMusic(String name, String artist, String album, java.util.Map<String, String> context)
    {
        _iceI_addMusicAsync(name, artist, album, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> addMusicAsync(String name, String artist, String album)
    {
        return _iceI_addMusicAsync(name, artist, album, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> addMusicAsync(String name, String artist, String album, java.util.Map<String, String> context)
    {
        return _iceI_addMusicAsync(name, artist, album, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_addMusicAsync(String iceP_name, String iceP_artist, String iceP_album, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "addMusic", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                     ostr.writeString(iceP_artist);
                     ostr.writeString(iceP_album);
                 }, null);
        return f;
    }

    default boolean addMusicPath(String name)
    {
        return addMusicPath(name, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean addMusicPath(String name, java.util.Map<String, String> context)
    {
        return _iceI_addMusicPathAsync(name, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> addMusicPathAsync(String name)
    {
        return _iceI_addMusicPathAsync(name, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> addMusicPathAsync(String name, java.util.Map<String, String> context)
    {
        return _iceI_addMusicPathAsync(name, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_addMusicPathAsync(String iceP_name, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "addMusicPath", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    default void playMusic(int id)
    {
        playMusic(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void playMusic(int id, java.util.Map<String, String> context)
    {
        _iceI_playMusicAsync(id, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> playMusicAsync(int id)
    {
        return _iceI_playMusicAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> playMusicAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_playMusicAsync(id, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_playMusicAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "playMusic", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, null);
        return f;
    }

    default boolean stopMusic()
    {
        return stopMusic(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean stopMusic(java.util.Map<String, String> context)
    {
        return _iceI_stopMusicAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> stopMusicAsync()
    {
        return _iceI_stopMusicAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> stopMusicAsync(java.util.Map<String, String> context)
    {
        return _iceI_stopMusicAsync(context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_stopMusicAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "stopMusic", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    default boolean remove(int id)
    {
        return remove(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean remove(int id, java.util.Map<String, String> context)
    {
        return _iceI_removeAsync(id, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> removeAsync(int id)
    {
        return _iceI_removeAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> removeAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_removeAsync(id, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_removeAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "remove", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    default Music findById(int id)
    {
        return findById(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Music findById(int id, java.util.Map<String, String> context)
    {
        return _iceI_findByIdAsync(id, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Music> findByIdAsync(int id)
    {
        return _iceI_findByIdAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Music> findByIdAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_findByIdAsync(id, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Music> _iceI_findByIdAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Music> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findById", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, istr -> {
                     Music ret;
                     ret = Music.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default Music[] findByName(String name)
    {
        return findByName(name, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Music[] findByName(String name, java.util.Map<String, String> context)
    {
        return _iceI_findByNameAsync(name, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Music[]> findByNameAsync(String name)
    {
        return _iceI_findByNameAsync(name, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Music[]> findByNameAsync(String name, java.util.Map<String, String> context)
    {
        return _iceI_findByNameAsync(name, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Music[]> _iceI_findByNameAsync(String iceP_name, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Music[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByName", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                 }, istr -> {
                     Music[] ret;
                     ret = playlistHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default Music[] findByArtist(String artist)
    {
        return findByArtist(artist, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Music[] findByArtist(String artist, java.util.Map<String, String> context)
    {
        return _iceI_findByArtistAsync(artist, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Music[]> findByArtistAsync(String artist)
    {
        return _iceI_findByArtistAsync(artist, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Music[]> findByArtistAsync(String artist, java.util.Map<String, String> context)
    {
        return _iceI_findByArtistAsync(artist, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Music[]> _iceI_findByArtistAsync(String iceP_artist, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Music[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByArtist", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_artist);
                 }, istr -> {
                     Music[] ret;
                     ret = playlistHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default Music[] findByAlbum(String album)
    {
        return findByAlbum(album, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Music[] findByAlbum(String album, java.util.Map<String, String> context)
    {
        return _iceI_findByAlbumAsync(album, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Music[]> findByAlbumAsync(String album)
    {
        return _iceI_findByAlbumAsync(album, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Music[]> findByAlbumAsync(String album, java.util.Map<String, String> context)
    {
        return _iceI_findByAlbumAsync(album, context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Music[]> _iceI_findByAlbumAsync(String iceP_album, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Music[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByAlbum", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_album);
                 }, istr -> {
                     Music[] ret;
                     ret = playlistHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default void display()
    {
        display(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void display(java.util.Map<String, String> context)
    {
        _iceI_displayAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> displayAsync()
    {
        return _iceI_displayAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> displayAsync(java.util.Map<String, String> context)
    {
        return _iceI_displayAsync(context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_displayAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "display", null, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default Music[] getPlaylist()
    {
        return getPlaylist(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Music[] getPlaylist(java.util.Map<String, String> context)
    {
        return _iceI_getPlaylistAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Music[]> getPlaylistAsync()
    {
        return _iceI_getPlaylistAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Music[]> getPlaylistAsync(java.util.Map<String, String> context)
    {
        return _iceI_getPlaylistAsync(context, false);
    }

    default com.zeroc.IceInternal.OutgoingAsync<Music[]> _iceI_getPlaylistAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Music[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getPlaylist", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Music[] ret;
                     ret = playlistHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static IServerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), IServerPrx.class, _IServerPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static IServerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), IServerPrx.class, _IServerPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static IServerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), IServerPrx.class, _IServerPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static IServerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), IServerPrx.class, _IServerPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static IServerPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, IServerPrx.class, _IServerPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static IServerPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, IServerPrx.class, _IServerPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default IServerPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (IServerPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default IServerPrx ice_adapterId(String newAdapterId)
    {
        return (IServerPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default IServerPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (IServerPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default IServerPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (IServerPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default IServerPrx ice_invocationTimeout(int newTimeout)
    {
        return (IServerPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default IServerPrx ice_connectionCached(boolean newCache)
    {
        return (IServerPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default IServerPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (IServerPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default IServerPrx ice_secure(boolean b)
    {
        return (IServerPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default IServerPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (IServerPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default IServerPrx ice_preferSecure(boolean b)
    {
        return (IServerPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default IServerPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (IServerPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default IServerPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (IServerPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default IServerPrx ice_collocationOptimized(boolean b)
    {
        return (IServerPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default IServerPrx ice_twoway()
    {
        return (IServerPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default IServerPrx ice_oneway()
    {
        return (IServerPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default IServerPrx ice_batchOneway()
    {
        return (IServerPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default IServerPrx ice_datagram()
    {
        return (IServerPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default IServerPrx ice_batchDatagram()
    {
        return (IServerPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default IServerPrx ice_compress(boolean co)
    {
        return (IServerPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default IServerPrx ice_timeout(int t)
    {
        return (IServerPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default IServerPrx ice_connectionId(String connectionId)
    {
        return (IServerPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default IServerPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (IServerPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::server::IServer";
    }
}
