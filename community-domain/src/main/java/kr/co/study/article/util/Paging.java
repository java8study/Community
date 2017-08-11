package kr.co.study.article.util;

public class Paging {

	private int totalArticleCount;

	private int printArticle;
	private int printPage;

	private int startArticleNumber;
	private int endArticleNumber;

	private int totalPage;
	private int totalGroup;

	private int nowGroupNumber;

	private int groupStartPage;

	private int nextGroupPageNumber;
	private int prevGroupPageNumber;

	private int pageNo;

	public Paging() {
		this.printArticle = 10;
		this.printPage = 10;
	}
	
	public Paging(int printArticle, int printPage) {
		this.printArticle = printArticle;
		this.printPage = printPage;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNo = 0;
		try {
			this.pageNo = Integer.parseInt(pageNumber);
		} catch (NumberFormatException nfe) {
			this.pageNo = 0;
		}

		this.startArticleNumber = (this.pageNo * this.printArticle) + 1;
		this.endArticleNumber = this.startArticleNumber + this.printArticle - 1;

		this.nowGroupNumber = this.pageNo / this.printPage;
		this.groupStartPage = (this.nowGroupNumber * this.printPage) + 1;

		this.nextGroupPageNumber = this.groupStartPage + this.printPage - 1;
		this.prevGroupPageNumber = this.groupStartPage - this.printPage - 1;
	}

	public void setTotalArticleCount(int count) {
		this.totalArticleCount = count;

		this.totalPage = (int) Math.ceil((double) this.totalArticleCount
				/ this.printArticle);
		this.totalGroup = (int) Math.ceil((double) this.totalPage
				/ this.printPage);
	}

	public int getTotalArticleCount() {
		return this.totalArticleCount;
	}

	public int getStartArticleNumber() {
		return this.startArticleNumber;
	}
	
	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}

	public void setEndArticleNumber(int endArticleNumber) {
		this.endArticleNumber = endArticleNumber;
	}

	public int getEndArticleNumber() {
		return this.endArticleNumber;
	}
	
	public String getPagingList(String link, String pageFormat, String prev, String next) {
		return getPagingList(link, pageFormat, prev, next, "");
	}

	public String getPagingList(String link, String pageFormat, String prev, String next, String formId) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("<script>");
		buffer.append("function movePage(pageNo) {");
		buffer.append("$(\"#"+link+"\").val(pageNo);");
		buffer.append("$(\"#"+formId+"\").attr('action', '');");
		buffer.append("$(\"#"+formId+"\").attr('method', 'post');");
		buffer.append("$(\"#"+formId+"\").submit();");
		buffer.append("}");
		buffer.append("</script>");
		
		buffer.append("<input type=\"hidden\" id=\""+link+"\" name=\""+link+"\" />");
		
		if (this.nowGroupNumber > 0) {
			buffer.append("<a href=\"javascript:movePage('"+this.prevGroupPageNumber+"')\">" + prev + "</a>");
		}

		int nextPrintPage = this.groupStartPage + this.printPage;
		if (nextPrintPage > this.totalPage) {
			nextPrintPage = this.totalPage + 1;
		}

		String pageNumber = "";

		for (int i = this.groupStartPage; i < nextPrintPage; i++) {
			pageNumber = pageFormat.replaceAll("@", i + "");
			if ((i - 1) == this.pageNo) {
				pageNumber = "<b>" + pageNumber + "</b>";
			}
			buffer.append("<a href=\"javascript:movePage('"+(i - 1)+"')\">" + pageNumber + "</a>");
		}

		if (this.nowGroupNumber < (this.totalGroup - 1)) {
			buffer.append("<a href=\"javascript:movePage('"+this.nextGroupPageNumber+"')\">" + next + "</a>");
		}

		return buffer.toString();
	}

}