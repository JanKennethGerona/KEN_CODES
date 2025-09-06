/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skiplist;

/**
 *
 * @author jkdgerona
 */
public class IntSkipListNode {
    public int key;
    public IntSkipListNode[] next;
    IntSkipListNode(int i, int n) {
        key = i;
        next = new IntSkipListNode[n];
        for (int j = 0; j < n; j++)
            next[j] = null;
}
}
