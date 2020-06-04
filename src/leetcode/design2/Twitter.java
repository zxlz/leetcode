package leetcode.design2;

import java.util.*;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {
    class TweeNode{
        int id;
        int time;
        TweeNode next;
        TweeNode pre;
        TweeNode(int id , int time){
            this.id=id;
            this.time=time;
        }
    }
    class UserData{
        HashSet<Integer> follow = new HashSet<>();//关注的用户
        int TweeSize = 0;
        TweeNode headTwee = new TweeNode(0,Integer.MIN_VALUE);//发的twitter，上限10条，用链表 方便合并
//        TweeNode curTwee = null;
        UserData(){
//            curTwee=headTwee;
        }
        void addHead(TweeNode t){
            t.next=headTwee.next;
            headTwee.next=t;
            TweeSize++;
        };

        void remove() {
            //remove先空着，不影响结果和效率
//            headTwee=headTwee.next;
//            TweeSize--;
        }
    }

    int maxSize;
    int timestamp;
    HashMap<Integer,UserData> dataMap;//存储每个用户的发送数据
    /** Initialize your data structure here. */
    public Twitter() {
        maxSize=10;
        timestamp=0;
        dataMap= new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        UserData userData = dataMap.get(userId);
        if(userData==null){//新用户就新增userdata
            userData = new UserData();
            userData.addHead(new TweeNode(tweetId,timestamp++));
            dataMap.put(userId,userData);
        }else{
            if(userData.TweeSize==maxSize)userData.remove();//满了就出队列一个最早发的
            userData.addHead(new TweeNode(tweetId,timestamp++));
        }

    }
    PriorityQueue<TweeNode> minHeap=new PriorityQueue<TweeNode>(new Comparator<TweeNode>() {
        @Override
        public int compare(TweeNode o1, TweeNode o2) {
            return o2.time-o1.time;//时间最大的放前面
        }
    });

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    //取出关注用户的twitter，合并k个链表，返回结果
    public List<Integer> getNewsFeed(int userId) {
        UserData userData = dataMap.get(userId);
        if(userData!=null){
            minHeap.clear();
            Integer[] res = new Integer[10];

            //取出关注用户twitter放入时间最近堆
            if(userData.TweeSize>0) minHeap.add(userData.headTwee.next);
            for (Integer integer : userData.follow) {
                UserData u= dataMap.get(integer);
                if(u!=null && u.TweeSize>0){//没有判断null用户
                    minHeap.add(dataMap.get(integer).headTwee.next);
                }
            }
            //合并堆的第一个
            TweeNode curNode = null;
            int next=0;
            while((curNode = minHeap.poll())!=null && next<10){//取出最近时间的一个twee。放入结果
                res[next++]=curNode.id;//存入结果
                if(curNode.next!=null) minHeap.offer(curNode.next);//有下一个节点，放入堆比较
            }
            res = Arrays.copyOf(res,next);
            return Arrays.asList(res);
        }
        return new ArrayList<>();
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId)return ;
        UserData userData = dataMap.get(followerId);
        if(userData==null){//新用户就新增userdata
            userData = new UserData();
            userData.follow.add(followeeId);
            dataMap.put(followerId,userData);
        }else{
            userData.follow.add(followeeId);//老用户直接关注
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        UserData userData = dataMap.get(followerId);
        if(userData!=null){
            userData.follow.remove(followeeId);//取消关注
        }
    }
}
