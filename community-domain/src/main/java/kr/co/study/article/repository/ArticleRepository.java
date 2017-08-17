package kr.co.study.article.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.article.dto.ArticleDTO;
import kr.co.study.article.dto.ArticleSearchDTO;
import kr.co.study.article.dto.ReplyDTO;

@Mapper
@Repository
public interface ArticleRepository {

	public void writeNewArticle(ArticleDTO articleDTO);

	public List<ArticleDTO> getAllArticleList(ArticleSearchDTO searchDTO);

	public void deleteArticleByArticleId(int articleId);

	public ArticleDTO getOneArticleByArticleId(int articleId);

	public void updateArticleByArticleDTO(ArticleDTO articleDTO);

	public int getTotalArticleCount(ArticleSearchDTO searchDTO);

	public void readsCountUpByArticleId(int articleId);

	public void upLikesCount(ArticleDTO articleDTO);

	public void writeReplyByUserNameAndArticleId(ReplyDTO replyDTO);

	public List<ReplyDTO> viewReplyList(int articleId);
	
}
