package com.算法笔记.每日一题;

import com.算法笔记.二叉树.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *@title Problem01
 *@description todo 2458. 移除子树后的二叉树高度
 *@author LYH
 *@version 1.0
 *@create 2024/1/5 19:29
 */
public class Problem01 {
    //记录每颗子树的高度，即最长路径的节点数
    private Map<TreeNode,Integer>subTreeHeight=new HashMap<>();
    private int[] ans;
    public int[] treeQueries(TreeNode root, int[] queries) {
         getHeight(root);
         ans=new int[subTreeHeight.size()+1];
         //注意
         subTreeHeight.put(null,0);
         dfs(root,-1,0);
         for(int i=0;i<queries.length;i++){
             queries[i]=ans[queries[i]];
         }
         return queries;
    }
    //当前节点深度 depth（从 0开始），
    //以及删除当前子树后剩余部分的树的高度 restH（这里定义成最长路径的边数）
    private int getHeight(TreeNode node) {
        if(node==null)return 0;
        int h= Math.max(getHeight(node.left),getHeight(node.right))+1;
        subTreeHeight.put(node,h);
        return h;
    }
    private void dfs(TreeNode node, int height, int restH) {
        if(node==null)return;
        height++;
        ans[node.val]=restH;
        dfs(node.left,height,Math.max(restH,height+subTreeHeight.get(node.right)));
        dfs(node.right,height,Math.max(restH,height+subTreeHeight.get(node.left)));
    }
}
