package org.successor.dao;

import org.successor.domin.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {

    int addFeedback(Feedback feedback);

    List<Feedback> queryAllNotRead();

    int setOneRead(int id);

    int setAllRead();
}
