package com.xzit.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: tb_permission
 */
@Data
public class Permission implements Serializable {
    /**
     * 权限id
     *
     * Table:     tb_permission
     * Column:    id
     * Nullable:  false
     */
    private String id;

    /**
     * 所属父级权限的id
     *
     * Table:     tb_permission
     * Column:    parent_id
     * Nullable:  false
     */
    private String parentId;

    /**
     * 权限名
     *
     * Table:     tb_permission
     * Column:    name
     * Nullable:  false
     */
    private String name;

    /**
     * 权限介绍
     *
     * Table:     tb_permission
     * Column:    intro
     * Nullable:  true
     */
    private String intro;

    /**
     * URL规则
     *
     * Table:     tb_permission
     * Column:    uri
     * Nullable:  false
     */
    private String uri;

    /**
     * 创建时间
     *
     * Table:     tb_permission
     * Column:    created_time
     * Nullable:  false
     */
    private Date createdTime;

    /**
     * 创建人
     *
     * Table:     tb_permission
     * Column:    creator
     * Nullable:  false
     */
    private String creator;

    /**
     * 最后编辑时间
     *
     * Table:     tb_permission
     * Column:    edited_time
     * Nullable:  false
     */
    private Date editedTime;

    /**
     * 编辑人
     *
     * Table:     tb_permission
     * Column:    editor
     * Nullable:  false
     */
    private String editor;

    /**
     * 是否被删除
     *
     * Table:     tb_permission
     * Column:    is_deleted
     * Nullable:  false
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_permission
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;
}