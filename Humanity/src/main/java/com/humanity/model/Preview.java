package com.humanity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PREVIEWS")
public class Preview {
	
	@Id
	@Column(name="PREVIEWS_CHAPTER", columnDefinition="NUMBER")
	private int previewChapter;
	
	@Column(name="PREVIEWS_TITLE", columnDefinition="VARCHAR2(255)")
	private String previewTitle;
	
	@Column(name="PREVIEWS_SYNOPSIS", columnDefinition="VARCHAR2(255)")
	private String previewSynopsis;
	
	@Column(name="PREVIEWS_RELEASEDATE")
	@Temporal(TemporalType.DATE)
	private Date previewReleaseDate;
	
	
	public Preview() {
		super();
	}

	public Preview(int previewChapter, String previewTitle, Date previewReleaseDate, String previewSynopsis) {
		super();
		this.previewChapter = previewChapter;
		this.previewTitle = previewTitle;
		this.previewReleaseDate = previewReleaseDate;
		this.previewSynopsis = previewSynopsis;
		
	}

	public int getPreviewChapter() {
		return previewChapter;
	}

	public void setPreviewChapter(int previewChapter) {
		this.previewChapter = previewChapter;
	}

	public String getPreviewTitle() {
		return previewTitle;
	}

	public void setPreviewTitle(String previewTitle) {
		this.previewTitle = previewTitle;
	}

	public Date getPreviewReleaseDate() {
		return previewReleaseDate;
	}

	public void setPreviewReleaseDate(Date previewReleaseDate) {
		this.previewReleaseDate = previewReleaseDate;
	}

	public String getPreviewSynopsis() {
		return previewSynopsis;
	}

	public void setPreviewSynopsis(String previewSynopsis) {
		this.previewSynopsis = previewSynopsis;
	}

}
