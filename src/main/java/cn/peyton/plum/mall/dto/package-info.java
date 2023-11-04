/**
 * <h3>dto包 用在持久化层与业务逻辑层传递数据 </h3>
 * <pre>
 *     1. BO（Business Object）是一个封装业务逻辑的对象。BO用来在Service层处理业务规则，比如校验、计算、转换等。
 *              BO可以包含一个或多个DO对象的信息，也可以不包含DO对象的信息。
 *    2. DO（Data Object）是一个与数据库表结构对应的对象，也叫持久化对象。
 *              DO用来在DAO层和数据库进行交互，也可以在其他层使用，比如作为方法的参数或返回值。
 *    3. VO（View Object）是一个用来展示数据的对象。VO用来在View层表示视图模型，比如JSP、HTML等。
 *              VO可以包含与视图相关的信息，比如页面展示的数据、页面需要的样式等
 *    4. DTO（Data Transfer Object）是一个用来传输数据的对象。
 *              DTO用来在不同层或不同系统之间传递数据，比如从Service层传递到Controller层或View层。
 *              DTO可以包含与视图相关的信息，也可以包含与业务相关的信息。
 *    5. POJO（Plain Ordinary Java Object）是一个普通的Java对象，它没有任何特殊的要求或约束，可以用来表示任何类型的数据。
 *              POJO通常是其他数据模型的基础，比如DO、DTO、BO、VO等。
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/6/23 16:00
 * @version 1.0.0
 * </pre>
 */
package cn.peyton.plum.mall.dto;