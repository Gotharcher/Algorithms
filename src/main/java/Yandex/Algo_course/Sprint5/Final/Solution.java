// 101961997

package Yandex.Algo_course.Sprint5.Final;

/*
ПРИНЦИП РАБОТЫ
Ищем переданный ключ в BST. Придя в нужную ноду, готовимся удалить её. Нужно заменить эту ноду на крайнюю правую ноду левого поддрева или крайнюю левую правого.
При этом, если у крайней ноды будут потомки, надо будет сделать две перестановки - крайнюю ноду на удалённую, а крайнюю - на её потомка. По сути, это одинаковое преобразование,
только в случае, если у крайней ноды нет потомка, её позиция "заменяется" на null, и ничего не происходит.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Для начала, надо найти удаляемый элемент. Это рекурсивный поиск обходом BST. Если элемента нет, то удалять ничего не надо.
Для того чтобы дерево не распалось после удаления, надо поставить на место удаленного элемента какой-то существующий, удовлетворяющий критериям BST. Для этого выберем "Крайний левый элемент правого поддрева".
Если изначальное древо - вырожденное, у него нет правой ветви, то удаление элемента схоже с удалением из ЛинкедЛиста - вместо удаленного элемента встанет следующий. Это будет работать,
даже если удаляемый элемент является листом древа - вместо потомка у родителя удаляемого элемента будет null. Элементы будут идти последовательно, новый левый элемент будет меньше родителя. Дерево останется BST.
В случае, если правое поддрево - вырожденное, без левой ветви, таким элементом является корень этого поддрева. В таком случае, левое поддрево удаляемого элемента станет целиком левым поддревом корня правого
вырожденного поддрева. А корень встанет на место удаляемого элемента. Элементы вырожденного поддрева останутся BST. В основном древе сохранится принцип BST. В целом, дерево останется BST.
В остальных, нормальных, случаях, перемещаемый элемент будет внизу древа, у него гарантированно не будет левого потомка, но может быть правый. В таком случае, необходимо переместить правого потомка на место перемещаемого элемента.
Все элементы, перемещенного поддрева будут соответствовать принципу BST. Если правого потомка нет, ничего не произойдет, а родитель перемещаемого элемента корректно лишен левого потомка.
В любом случае, после перемещения крайнего элемента на место удаленного, принцип BST сохранится - все элементы в правом поддреве будут меньше исходного.

Важное замечание, необходимое для корректного обхода измененного древа: когда мы помещаем крайний элемент вместо удаляемого, мы прописываем родителю нового потомка - перемещенный элемент. Если у удаляемого элемента нет родителя - т.е. он является корнем, корнем древа становится перемещенный элемент.
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Поиск элемента занимает O(h), где h - высота древа. Нужно найти удаляемый элемент и далее крайний левый в правом поддреве - это делается в один проход и займёт O(h).
При этом, родители элементов промежуточно сохраняются, то есть нет необходимости заново их искать.
Дополнительные обходы коллекции не используются, только перестановки с сохраненными элементами.
Итоговая временная сложность: O(h)
*/

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Изначальная сложность - О(N), где N - число узлов древа.
Дополнительных структур данных не создается, перестановки выполняются in-place, через swap-константы. Таким образом, дополнительная пространственная сложность О(1).
Итоговая сложность: O(N).
 */

public class Solution {

    static Node headRoot;

    public static Node remove(Node root, int key) {
        headRoot = root;
        NodeCarrier deletedNode = findNodeToBeDeleted(new NodeCarrier(null, root), key);
        if (deletedNode == null) {
            return headRoot; //Переданного ключа нет в BST
        }

        if (deletedNode.currNode.getRight() == null) { //правого поддрева нет
            //Левая нода должна встать вместо удаляемой ноды
            setNewSiblingToRootWhenDeleting(deletedNode.parent, deletedNode.currNode, deletedNode.currNode.getLeft());
            //Даже если левого поддрева тоже нет, ничего не произойдет, а корнем древа станет новый элемент.
            //И всё, удаление завершено.
            return headRoot;
        }
        //Крайняя левая нода в правом поддреве
        NodeCarrier newSubrootCarrier = rightSubtreeLeftDeadEnd(new NodeCarrier(deletedNode.currNode, deletedNode.currNode.getRight()));
        //Поместим в буфер ноду, которая пойдет вместо удаляемой.
        Node bufferedNodeToBeSwappedWithDeleted = newSubrootCarrier.currNode;

        if (newSubrootCarrier.parent == deletedNode.currNode) {
            //Если удаляем родителя крайней ноды, то нужно только привязать к нему старое левое поддрево
            bufferedNodeToBeSwappedWithDeleted.setLeft(deletedNode.currNode.getLeft());
        } else {
            //Поставим вместо буфер-ноды её правого потомка. Если там Null, значит, потомков у ноды нет, значит просто корректно обнулим потомка для родителя буфер-ноды.
            newSubrootCarrier.parent.setLeft(newSubrootCarrier.currNode.getRight());
            //Вырежем удаляемую ноду - передадим её потомков буфер-ноде, а у её родителя заменим нужного потомка на буфер-ноду.
            bufferedNodeToBeSwappedWithDeleted.setLeft(deletedNode.currNode.getLeft());
            bufferedNodeToBeSwappedWithDeleted.setRight(deletedNode.currNode.getRight());
        }

        setNewSiblingToRootWhenDeleting(deletedNode.parent, deletedNode.currNode, bufferedNodeToBeSwappedWithDeleted);

        return headRoot;
    }

    public static void setNewSiblingToRootWhenDeleting(Node parent, Node deleting, Node newNode) {
        if (parent == null) {
            //Если родителя нет, т.е. удаляемый элемент - корень, то корнем становится новый элемент.
            headRoot = newNode;
            return;
        }
        if (parent.getLeft() == deleting) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public static NodeCarrier findNodeToBeDeleted(NodeCarrier fromSearch, int key) {
        if (fromSearch.currNode == null) { //Переданного ключа нет в BST
            return null;
        }
        if (fromSearch.getValue() == key) {
            return fromSearch;
        } else {
            fromSearch.parent = fromSearch.currNode;
            if (fromSearch.getValue() > key) {
                fromSearch.currNode = fromSearch.parent.getLeft();
            } else {
                fromSearch.currNode = fromSearch.parent.getRight();
            }
            return findNodeToBeDeleted(fromSearch, key);
        }
    }

    public static NodeCarrier rightSubtreeLeftDeadEnd(NodeCarrier initNodeCarrier) {
        if (initNodeCarrier.currNode.getLeft() == null) {
            return initNodeCarrier;
        } else {
            initNodeCarrier.parent = initNodeCarrier.currNode;
            initNodeCarrier.currNode = initNodeCarrier.parent.getLeft();
            return rightSubtreeLeftDeadEnd(initNodeCarrier);
        }
    }
}

//Нужно не только знать ноду, но и её родителя. Будем хранить её в классе, аналогичном Pair'у.
class NodeCarrier {
    public Node parent, currNode;

    public NodeCarrier(Node parent, Node currNode) {
        this.parent = parent;
        this.currNode = currNode;
    }

    public int getValue() {
        return this.currNode.getValue();
    }

}

// <template>
class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
// <template>