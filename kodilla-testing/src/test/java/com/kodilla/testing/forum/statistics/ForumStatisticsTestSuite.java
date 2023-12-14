package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @BeforeEach
    public void beforeTest(){
        statisticsMock = mock(Statistics.class);
        List<String>listMock = new ArrayList<>();
        for(int i=0; i<10; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        forumStatistics = new ForumStatistics();
    }

    @DisplayName("Test Calculate Adv Statistics With Zero Posts")
    @Order(1)
    @Test
    public void testCalculateAdvStatisticsWithZeroPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsQty());
        assertEquals(0, forumStatistics.getPostsAvgPerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAvgPerPost(), 0.01);

    }

    @DisplayName("Test Calculate Adv Statistics With Thousand Posts")
    @Order(2)
    @Test
    public void testCalculateAdvStatisticsWithThousandPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, forumStatistics.getPostsQty());
        assertEquals(100, forumStatistics.getPostsAvgPerUser(), 0.01);
        assertEquals(0.04, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @DisplayName("Test Calculate Adv Statistics With Zero Comments")
    @Order(3)
    @Test
    public void testCalculateAdvStatisticsWithZeroComments(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getCommentsQty());
        assertEquals(0, forumStatistics.getCommentsAvgPerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @DisplayName("Test Calculate Adv Statistics Less Comments Than Posts")
    @Order(4)
    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(10);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(10, forumStatistics.getPostsQty());
        assertEquals(2, forumStatistics.getCommentsQty());
        assertEquals(1, forumStatistics.getPostsAvgPerUser(), 0.01);
        assertEquals(0.2, forumStatistics.getCommentsAvgPerUser(), 0.01);
        assertEquals(0.2, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @DisplayName("Test Calculate Adv Statistics More Comments Than Posts")
    @Order(5)
    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){
        //Given

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(20, forumStatistics.getPostsQty());
        assertEquals(40, forumStatistics.getCommentsQty());
        assertEquals(2, forumStatistics.getPostsAvgPerUser(), 0.01);
        assertEquals(4, forumStatistics.getCommentsAvgPerUser(), 0.01);
        assertEquals(2, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @DisplayName("Test Calculate Adv Statistics With Zero Users")
    @Order(6)
    @Test
    public void testCalculateAdvStatisticsWithZeroUsers(){
        //Given
        List<String>listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getUsersQty());
        assertEquals(0, forumStatistics.getPostsAvgPerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAvgPerUser(), 0.01);

    }

    @DisplayName("Test Calculate Adv Statistics With Hundred Users")
    @Order(7)
    @Test
    public void testCalculateAdvStatisticsWithHundredUsers(){
        //Given
        List<String> listMock = new ArrayList<>();
        for(int i=0; i<100; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getUsersQty());
        assertEquals(0.2, forumStatistics.getPostsAvgPerUser(), 0.01);
        assertEquals(0.4, forumStatistics.getCommentsAvgPerUser(), 0.01);
    }

    @DisplayName("Test Show Statistics")
    @Order(8)
    @Test
    public void testShowStatistics(){
        //Given

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getShowStatistics());
    }
}