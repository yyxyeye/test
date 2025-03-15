//package com.imooc.service.impl.kugou;
//
//import com.github.pagehelper.PageHelper;
//import com.imooc.mapper.SysUserMapper;
//import com.imooc.mapper.SysUserMapperCustom;
//import com.imooc.mapper.kugou.ClanActivityInfoMapper;
//import com.imooc.pojo.SysUser;
//import com.imooc.pojo.kugou.ClanActivityInfo;
//import com.imooc.service.UserService;
//import com.imooc.service.kugou.ClanActivityInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.thymeleaf.util.StringUtils;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.List;
//
//@Service
//public class ClanActivityInfoServiceImpl implements ClanActivityInfoService {
//
//	@Autowired
//	private ClanActivityInfoMapper clanActivityInfoMapper;
//
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public void saveClanActivityInfo(ClanActivityInfo clanActivityInfo) throws Exception {
//
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		clanActivityInfoMapper.insert(clanActivityInfo);
//	}
//
//}
