package com.kude.communication.service;

import com.kude.communication.Exception.CustomizeErrorCode;
import com.kude.communication.Exception.CustomizeException;
import com.kude.communication.dto.PaginationDTO;
import com.kude.communication.dto.QuestionDTO;
import com.kude.communication.mapper.QuestionExtMapper;
import com.kude.communication.mapper.QuestionMapper;
import com.kude.communication.mapper.UserMapper;
import com.kude.communication.model.Question;
import com.kude.communication.model.QuestionExample;
import com.kude.communication.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/9/14 17:13
 * @Message
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    public PaginationDTO selectList(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        if (totalCount % size == 0) {
            paginationDTO.setTotalPage(totalCount / size);
        } else {
            paginationDTO.setTotalPage(totalCount / size + 1);
        }

        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        paginationDTO.setPagination(paginationDTO.getTotalPage(), page);
        Integer offset = size * (page - 1);

//        List<Question> questions = questionMapper.list(offset, size);
        QuestionExample example = new QuestionExample();
        List<Question> questions = questionMapper.selectByExampleWithBLOBsWithRowbounds(example, new RowBounds(offset, size));
        //因为最后返回的是list集合，所以创建又一个ArrayList对象
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        //遍历question集合，取到list中所有元素
        for (Question question : questions) {
            //通过id来获取用户所有信息，
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //将question中的对象copy到questionDTO中，的当然也可以用set方法，这种方法相对简单
            BeanUtils.copyProperties(question, questionDTO);
            //将user信息赋值给QuestionDTO中的user
            questionDTO.setUser(user);
            //把元素放到集合中去
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    //我的问题页面
    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;

        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userId);
        Integer totalCount = (int) questionMapper.countByExample(questionExample);

//        Integer totalCount = questionMapper.countByUserId(userId);
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        Integer offset = size * (page - 1);

        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(userId);
        List<Question> questions = questionMapper.selectByExampleWithBLOBsWithRowbounds(example, new RowBounds(offset, size));

//        List<Question> questions = questionMapper.listByUserId(userId, offset, size);



        //因为最后返回的是list集合，所以创建又一个ArrayList对象
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        //遍历question集合，取到list中所有元素
        for (Question question : questions) {
            //通过id来获取用户所有信息，
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //将question中的对象copy到questionDTO中，的当然也可以用set方法，这种方法相对简单
            BeanUtils.copyProperties(question, questionDTO);
            //将user信息赋值给QuestionDTO中的user
            questionDTO.setUser(user);
            //把元素放到集合中去
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {

        Question question = questionMapper.selectByPrimaryKey(id);

        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }

        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //创建问题
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            //更新
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample example = new QuestionExample();
            example.createCriteria()
                    .andIdEqualTo(question.getId());
           int updated = questionMapper.updateByExampleSelective(updateQuestion, example);

            if (updated != 1) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    //增加阅读量
    public void incView(Integer id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }
}
