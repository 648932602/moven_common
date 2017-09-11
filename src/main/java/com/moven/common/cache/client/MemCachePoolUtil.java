package com.moven.common.cache.client;

public class MemCachePoolUtil {
//	// 设置默认的客户端
//	private static MemCachedClient memCachedClient;
//
//	static {
//		initialize();
//	}
//
//	public static void reloadConfig() {
//		try {
//			String[] servers = {"127.0.0.1:11211"};
//			SockIOPool pool = SockIOPool.getInstance();
//			// 设置连接池可用的cache服务器列表，server的构成形式是IP:PORT（如：127.0.0.1:11211）
//			pool.setServers(servers);
//			// 设置容错开关设置为TRUE，当前socket不可用时，程序会自动查找可用连接并返回，否则返回NULL，默认状态是true，建议保持默认。
//			pool.setFailover(true);
//			// 设置开始时每个cache服务器的可用连接数
//			pool.setInitConn(100);
//			// 设置每个服务器最少可用连接数
//			pool.setMinConn(50);
//			// 设置每个服务器最大可用连接数
//			pool.setMaxConn(4000);
//			// 设置可用连接池的最长等待时间
//			pool.setMaintSleep(30);
//			// 设置是否使用Nagle算法，因为我们的通讯数据量通常都比较大（相对TCP控制数据）而且要求响应及时，因此该值需要设置为false（默认是true）
//			pool.setNagle(false);
//			// 设置socket 的读取等待超时值
//			pool.setSocketTO(60000);
//			// 设置连接心跳监测开关。设为true则每次通信都要进行连接是否有效的监测，造成通信次数倍增，加大网络负载，因此该参数应该在对HA要求比较高的场合设为TRUE，默认状态是false。
//			pool.setAliveCheck(true);
//			
//			pool.initialize();
//		} catch (Exception e) {
//			LogUtil.error(MemCachePoolUtil.class, e);
//		}
//	}
//	
//	/**
//	 * 初始化方法
//	 */
//	private static void initialize(){
//		memCachedClient = new MemCachedClient();
//		reloadConfig();
//	}
//	
//	/**
//	 * 获取memCached客户端方法
//	 * @return
//	 */
//	public static MemCachedClient getMemCachedClient(){
//		if(Util.isBlank(memCachedClient)){
//			initialize();
//		}
//		return memCachedClient;
//	}
}
