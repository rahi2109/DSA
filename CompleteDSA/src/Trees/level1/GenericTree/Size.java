package Trees.level1.GenericTree;

public class Size {

	public static int size(TreeNode root) {
		int size=0;
		for(int i=0;i<root.children.size();i++) {
			int childsize=size(root.children.get(i));
			size+=childsize;
		}
		return 1+size;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BuildTree bt=new BuildTree();
		TreeNode root=bt.construct();
		System.out.println(size(root));
	}

}
