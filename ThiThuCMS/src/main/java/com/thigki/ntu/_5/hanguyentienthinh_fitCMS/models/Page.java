package com.thigki.ntu._5.hanguyentienthinh_fitCMS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "page")
public class Page {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	@Column(name = "page_name")
    private String pageName;
	@Column(name = "keyword")
    private String keyword;
	@Column(name = "content")
    private String content;
	@Column(name = "parent_page_id")
    private Integer parentPageId;
	

    
    public Page() {
    }

  
    public Page(int id, String pageName, String keyword, String content, Integer parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPageName() { return pageName; }
    public void setPageName(String pageName) { this.pageName = pageName; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Integer getParentPageId() { return parentPageId; }
    public void setParentPageId(Integer parentPageId) { this.parentPageId = parentPageId; }
}
