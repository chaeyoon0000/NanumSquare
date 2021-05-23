package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.nanum.HomeController;
import controller.nanum.*;
import controller.diary.*;
import controller.game.*;
import controller.comment_d.*;
import controller.comment_d_c.*;
import controller.qna.*;
import controller.ranking.RankingDiaryController;
import controller.category.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/views/home", new HomeController());
        
        mappings.put("/views/user/login", new LoginUserController());
        mappings.put("/views/user/logout", new LogoutUserController());
        mappings.put("/views/user/register", new RegisterUserController()); // view form(GET) & update(POST)
        mappings.put("/views/user/mypage", new MyPageController());
        mappings.put("/views/user/friend/delete", new DeleteFriendController());
        mappings.put("/views/user/following/request", new RequestFollowingController());
        mappings.put("/views/user/following/accept", new AcceptFollowingController());
        mappings.put("/views/user/following/reject", new RejectFollowingController());
        mappings.put("/views/user/following/cancel", new CancelFollowingController());
        
        mappings.put("/views/circle/list", new ListCircleController());
        mappings.put("/views/circle/detail", new DetailCircleController());
        mappings.put("/views/circle/form", new RegisterCircleController());
        mappings.put("/views/circle/update", new UpdateCircleController()); // view form(GET) & update(POST)
        mappings.put("/views/circle/delete", new DeleteCircleController());
        mappings.put("/views/circle/apply", new ApplyCircleController());
        
        mappings.put("/views/diary/list", new ListDiaryController());
        mappings.put("/views/diary/detail", new DetailDiaryController());
        mappings.put("/views/diary/friend/list", new FriendListController());
        mappings.put("/views/diary/keyword", new SearchDiaryController());
        mappings.put("/views/diary/register", new RegistrationDiaryController());
        mappings.put("/views/diary/register/form", new ForwardController("/views/diary/register.jsp"));
        mappings.put("/views/diary/update", new UpdateDiaryController());
        mappings.put("/views/diary/update/form", new UpdateDiaryFormController());
        mappings.put("/views/diary/delete", new DeleteDiaryController());
        mappings.put("/views/diary/likey", new LikeyDiaryController());
        mappings.put("/views/diary/s_user", new SearchDiaryByUserController());
        
        mappings.put("/views/comment_d/delete", new Comment_dDeleteController());
        mappings.put("/views/comment_d/register", new Comment_dRegistrationController());
        
        mappings.put("/views/comment_d_c/register", new Comment_d_cRegistrationController());
        mappings.put("/views/comment_d_c/register/form", new Comment_d_cRegistrationFormController());
        mappings.put("/views/comment_d_c/delete", new Comment_d_cDeleteController());
        
        mappings.put("/views/qna/list", new ListQnAController());
        mappings.put("/views/qna/datail", new DetailQnAController());
        mappings.put("/views/qna/s_keyword", new SearchQnAController());
        mappings.put("/views/qna/s_user", new SearchQnAByUserController());
        mappings.put("/views/qna/write/form", new ForwardController("/views/qna/form.jsp"));
        mappings.put("/views/qna/write", new RegistertQnAController());
        mappings.put("/views/qna/update/form", new UpdateQnAController());
        mappings.put("/views/qna/update", new UpdateQnAController());
        mappings.put("/views/qna/delete", new DeleteQnAController());
        
        mappings.put("/views/category/CircleCategoryList", new CircleListCategoryController());
        mappings.put("/views/category/CircleView", new CircleViewCategoryController());
        mappings.put("/views/category/DiaryCategoryList", new DiaryListCategoryController());
        mappings.put("/views/category/DiaryView", new DiaryViewCategoryController());
        
        mappings.put("/views/game/list", new ListGameController());
        mappings.put("/views/game/detail", new DetailGameController());
        mappings.put("/views/game/form", new RegisterGameController());
        mappings.put("/views/game/update", new UpdateGameController());
        mappings.put("/views/game/delete", new DeleteGameController());
        mappings.put("/views/game/participate", new ParticipateGameController());
        
        //mappings.put("/views/ranking/Rank", new RankingDiaryController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
        return mappings.get(uri);
    }
}
