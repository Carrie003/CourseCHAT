package com.example.course_chat.interfaces;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;
import java.util.List;

public interface SearchInterface {

     void setUpSearchViews();
     void setUpSortingSpinner();
     List<?> getSortedListByVotes();
//     List<?> getSortedDiscussionListByCommentsOrReplies();

}
