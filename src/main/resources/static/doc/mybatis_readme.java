// 语法说明
/*
原符号:    <       <=      >       >=      &       '       "
转义:     &lt;    &lt;=   &gt;    &gt;=   &amp;   &apos;  &quot;
start_time &gt;= #{startTime} and end_time &lt;= #{endTime}
大于等于
<![CDATA[ >= ]]>
小于等于
<![CDATA[ <= ]]>

between 用法
create_time between #{startTime} and #{endTime}
 */

// 日期查询
/*
1. 查询今天
    select * from table where DATE(data_column) = CURDATE(); 或
    select * from table where TO_DAYS(data_column) = TO_DAYS(NOW());
  查询 昨天
    select * from table where TO_DAYS(NOW()) - TO_DAYS(data_column) <= 1;
2. 查询本周
    select * from table where YEARWEEK(data_column) = YEARWEEK(CURDATE());
3. 查询本月
    select * from table where MONTH(data_column) = MONTH(CURDATE()) AND YEAR(data_column) = YEAR(CURDATE());
4. 查询近三个月
    select * from table where QUARTER(data_column) = QUARTER(CURDATE());
5. 查询近半年
    select * from table where TIMESTAMPDIFF(MONTH,data_column,CURDATE()) <= 6;
6. 查询近一年
    select * from table where TIMESTAMPDIFF(YEAR,data_column,CURDATE()) <= 1;
7. 相询近三年
    select * from table where TIMESTAMPDIFF(YEAR,data_column,CURDATE()) <= 3;
 */


// 批量插入
/*
<insert id="batchInsert" parameterType="list" keyColumn="id" keyProperty="id" useGeneratedKeys="true">
    insert into `tb_shop_product_sku`
        (`sku_id`,`sku_value_id`,`product_id`)
    values
    <foreach collection="list" item="item" separator=",">
        (#{item.skuId},#{item.skuValueId},#{item.productId})
    </foreach>
</insert>
 */
//批量更新
/*
<foreach collection="skus" item="item" index="index" separator=";">
    update `tb_shop_sku`
    <set>
        `seq`= #{item.seq}
    </set>
        where id = #{item.id}
</foreach>

<update id="batchDelete" parameterType="list">
    update `tb_shop_product` set `is_del` = 0
    where id in
    <foreach collection="ids" open="(" close=")" separator="," item="id">
        #{id}
    </foreach>
</update>

<update id="batchUpdateSaleCount" parameterType="list">
    <foreach collection="products" index="index" separator=";" item="item">
        update tb_shop_product
        set `sale_count` = #{item.saleCount}
        where `id`=#{item.id} and `is_del` = 1
    </foreach>
</update>
 */

// 批量删除
/*
第一种
<delete id="destroy" parameterType="list">
    delete  from `tb_shop_product` where id in (#{ids})
</delete>

第二种
<delete id="destroy1" parameterType="list">
    delete  from `tb_shop_product`
        where id in
     <foreach collection="ids" open="(" close=")" separator="," item="id">
         #{id}
     </foreach>
</delete>

 */

/*
* 随机获取数据
* SELECT * from sys_city ORDER BY RAND() LIMIT 10;
* */