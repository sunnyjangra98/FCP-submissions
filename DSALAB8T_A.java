/*
 * Dushyant Jangra
 * 2016035
 */
package dsa_labs;

import java.util.Scanner;

class bsnode{
	bsnode left,right;
	int data;
	public bsnode(){
		left=null;
		right=null;
		data=0;
	}
	public bsnode(int n){
		left=null;
		right=null;
		data=n;
	}
	public void setLeftLink(bsnode n){
		left=n;
	}
	public void setRightLink(bsnode n){
		right=n;
	}
	public bsnode getLeftLink(){
		return left;
	}
	public bsnode getRightLink(){
		return right;
	}
	public void setData(int n){
		data=n;
	}
	public int getData(){
		return data;
	}
}

class MAX_LEVEL{
	int max_level;
}

class bstree{
	private bsnode root;
	public bstree(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void insert(int data){
		root=insert(root,data);
	}
	private bsnode insert(bsnode node, int data){
		if (node==null){
			node=new bsnode(data);
		}
		else{
			if (data<=node.getData())
				node.left=insert(node.left,data);
			else
				node.right=insert(node.right,data);
		}
		return node;
	}
	public void delete(int k){
		root=delete(root,k);
    }
    private bsnode delete(bsnode root,int k){
        if (root.getData()==k){
            bsnode leftnode, rightnode;
            leftnode=root.getLeftLink();
            rightnode=root.getRightLink();
            if (leftnode==null && rightnode==null){
                root=null;
            	return null;
            }
            else if (root.getLeftLink()==null){
                root=root.getRightLink();
            }
            else if (root.getRightLink()==null){
                root=root.getLeftLink();
            }
            else{
                bsnode mini=minimum_value(rightnode);
                root.data=mini.data;
                root.right=delete(root.right,mini.data);
            }
        }
        else if (k<root.getData()){
            root.setLeftLink(delete(root.getLeftLink(),k));
        }
        else if (k>root.getData()){
            root.setRightLink(delete(root.getRightLink(),k));             
        }
        return root;
    }
    public bsnode minimum_value(bsnode root){
    	if (root.left==null)
    		return root;
    	else return minimum_value(root.left);
    }
    public void printRightProfile(){
    	printRightProfile(root);
    }
    public void printRightProfile(bsnode root){
    	MAX_LEVEL max=new MAX_LEVEL();
    	printRightProfile(root,1,max);
    }
    public void printRightProfile(bsnode root,int curr_level,MAX_LEVEL max_level){
    	if (root==null){
    		return ;
    	}
    	if (max_level.max_level<curr_level){
    		System.out.print(root.getData()+" ");
    		max_level.max_level=curr_level;
    	}
    	printRightProfile(root.getRightLink(),curr_level+1,max_level);
    	printRightProfile(root.getLeftLink(),curr_level+1,max_level);
    }
}

public class lab_8 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		bstree bst=new bstree();
		int n=in.nextInt();
		int q=in.nextInt();
		for (int i=0;i<n;i++)
			bst.insert(in.nextInt());
		while (q-->0){
			int query=in.nextInt();
			if (query==1){
				bst.delete(in.nextInt());
			}
			else if (query==2){
				bst.printRightProfile();
				System.out.println();
			}
		}
		in.close();
	}
}
