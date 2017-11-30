package com.moven.common.config;

/**
 * 数据库操作
 */
public enum DataOperation {
//	UserServiceImpl
	ADD_USER,
	GET_USER_BY_ID, 
	GET_USER_LIST,
//	RoleServiceImpl
	GET_ROLE_LIST,
//	AdminServiceImpl
	LOGIN, 
	GET_MENU_BY_ROLE_ID, 
	IS_REGISTERED, 
	REGISTER, 
//	ProductionServiceImpl
	GET_PRODUCTION_LIST,
	GET_PRODUCTION_BY_ID,
	ADD_PRODUCTION, 
	UPDATE_PRODUCTION, 
	DELETE_PRODUCTION
}
