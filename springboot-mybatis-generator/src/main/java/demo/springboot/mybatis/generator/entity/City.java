package demo.springboot.mybatis.generator.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`city`")
public class City {
    /**
     * 城市编号
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 省份编号
     */
    @Column(name = "`province_id`")
    private Integer provinceId;

    /**
     * 城市名称
     */
    @Column(name = "`city_name`")
    private String cityName;

    /**
     * 描述
     */
    @Column(name = "`description`")
    private String description;
}