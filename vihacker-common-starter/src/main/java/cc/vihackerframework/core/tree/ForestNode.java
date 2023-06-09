package cc.vihackerframework.core.tree;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 森林节点
 * Created by Ranger on 2022/05/28.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ForestNode extends TreeNode {

    private static final long serialVersionUID = -5188222097134746118L;

    /**
     * 节点内容
     */
    private Object content;

    public ForestNode(Long id, Long parentId, Object content) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
    }

}
