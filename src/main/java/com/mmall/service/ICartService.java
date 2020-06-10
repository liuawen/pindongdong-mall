package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2019-08-07
 */
public interface ICartService {
    //userId productId count
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
    //更新购物车商品 userId productId count
    ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);
    //userId products 可以选择删除多个
    ServerResponse<CartVo> deleteProduct(Integer userId,String productIds);
    //userId 用户id显示购物车
    ServerResponse<CartVo> list (Integer userId);
    //选择或取消
    ServerResponse<CartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
