package ru.specialist.processtart2.tree;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/* решение задачи обхода бинарного дерева 
с количеством уровней level +1
 */
public class Program {

    static Random rnd = new Random();
    static int total;

    public static void creatRandomTree(TreeNode node, int level) {

        node.left = new TreeNode();
        node.right = new TreeNode();
        node.weight = rnd.nextInt(100);
        total += node.weight;
        level--;

        if (level == 0) {
            node.left.weight = rnd.nextInt(100);
            node.right.weight = rnd.nextInt(100);
            total += node.left.weight;
            total += node.right.weight;
            return;
        }
        creatRandomTree(node.left, level);
        creatRandomTree(node.right, level);
    }

    public static int weightTree(TreeNode root) {
        return root.weight
                + (root.left != null ? weightTree(root.left) : 0)
                + (root.right != null ? weightTree(root.right) : 0);
    }
    
    public static int weighrTreeMulti(TreeNode root){
       
        class WeightCounter extends RecursiveTask<Integer>{
            TreeNode r;
            int level;

            public WeightCounter(TreeNode r, int level) {
                this.r = r;
                this.level = level;
            }
            @Override
            protected Integer compute(){
             final int newLevel = level-1;
             if(level<=0) return weightTree(r);
             
             int summ = r.weight;
             WeightCounter w1 = null, w2 = null;
             
             if(r.left != null){
                 w1 = new WeightCounter(r.left, newLevel);
                 w1.fork();// отправка подзадачи на выполнение
             }
               if(r.right != null){
                 w2 = new WeightCounter(r.right, newLevel);
                 w2.fork();
             }
               if(w1!=null)
                   summ += w1.join();
               if(w2!=null)
                   summ += w2.join();
               return summ;
            }
            
            
        }
        return ForkJoinPool.commonPool().invoke(
                new WeightCounter(root, Runtime.getRuntime().availableProcessors()));
    }
    public static void main(String[] args) {
        
       int treeLevel = 21;
       if(args.length>=1)
       treeLevel = Integer.parseInt(args[0]);
       
        System.out.println("Starting tree creation with dept: "+ (treeLevel+1));
        TreeNode root = new TreeNode();
        creatRandomTree(root, treeLevel);
        
        System.out.println("Tree created with total weight: " + total);
        
        long t1 = System.currentTimeMillis();
        int r1 = weightTree(root);
        long t2 = System.currentTimeMillis();
        System.out.println("Single weight:"+ r1+" "+(t2-t1));
        
        long t3 = System.currentTimeMillis();
        int r2 = weightTree(root);
        long t4 = System.currentTimeMillis();
        System.out.println("Multi weight:"+ r2+" "+(t4-t3));
        
        
    }
}
