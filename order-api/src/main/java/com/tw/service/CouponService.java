package com.tw.service;

import com.tw.helper.DateHelper;
import com.tw.mapper.CouponMapper;
import com.tw.mapper.UserCouponMapper;
import com.tw.model.Coupon;
import com.tw.model.CouponCriteria;
import com.tw.model.UserCoupon;
import com.tw.model.UserCouponCriteria;
import com.tw.view.CouponView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aisiA on 2019/5/24.
 */
@Component
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserCouponMapper userCouponMapper;

    public List<CouponView> selectCouponViewList(String userId){
        UserCouponCriteria userCouponCriteria=new UserCouponCriteria();
        userCouponCriteria.or().andUserIdEqualTo(userId);
        List<UserCoupon> list=userCouponMapper.selectByExample(userCouponCriteria);
        if(list!=null&&list.size()>0){
            List<CouponView>li=new ArrayList<CouponView>();
            for (UserCoupon userCoupon : list) {
                CouponView couponView=new CouponView();
                Coupon coupon=couponMapper.selectByPrimaryKey(userCoupon.getCouponId());
                couponView.setTypeMoney(coupon.getTypeMoney());
                couponView.setCouponStatus(userCoupon.getCouponStatus());
                couponView.setId(coupon.getId());
                couponView.setUserCouponId(userCoupon.getId());
                couponView.setMinGoodsAmount(coupon.getMinGoodsAmount());
                couponView.setName(coupon.getName());
                couponView.setUseEndDate(DateHelper.format(coupon.getUseEndDate()));
                li.add(couponView);
            }
            return li;
        }
        return null;
    }
    public Coupon selectCouponInfo(Integer couponId){
       return couponMapper.selectByPrimaryKey(couponId);
    }
}
