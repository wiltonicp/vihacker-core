package cc.vihackerframework.core.datasource.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 搜索封装类
 * Created by Ranger on 2022/02/20
 */
@Data
@Schema(description = "搜索条件")
public class QuerySearch implements Serializable {

	/**
	 * 关键词
	 */
	@Schema(description = "关键词")
	private String keyword;

	/**
	 * 开始日期
	 */
	@Schema(hidden = true)
	private String startDate;

	/**
	 * 结束日期
	 */
	@Schema(hidden = true)
	private String endDate;

	/**
	 * 排序属性
	 */
	@Schema(hidden = true)
	private String prop;

	/**
	 * 排序方式：asc,desc
	 */
	@Schema(hidden = true)
	private String order;

	/**
	 * 当前页
	 */
	@Schema(description = "当前页")
	private Integer current = 1;

	/**
	 * 每页的数量
	 */
	@Schema(description = "每页的数量")
	private Integer size = 10;
}
