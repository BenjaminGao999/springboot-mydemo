package com.example.jpa.jap.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author benjamin
 * created at 2019/8/23
 */
@Entity
@Table(name = "car")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDO {

    /**
     * Hibernate: create table car (id bigint not null,
     * car_country varchar(255),
     * brand_id integer,
     * brand_name varchar(16),
     * car_price integer,
     * is_car_country_germany bit, primary key (id)) engine=InnoDB
     */

    @Id
    private Long id;
    @Column
    private Integer brandId;
    @Column(length = 16)
    private String brandName;
    @Column
    private Integer car_price;
    @Column
    private String CAR_COUNTRY;
    @Column
    private Boolean is_car_countryGermany;

}
