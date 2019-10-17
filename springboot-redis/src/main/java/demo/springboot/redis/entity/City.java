package demo.springboot.redis.entity;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(name = "`city`")
public class City implements Serializable {
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