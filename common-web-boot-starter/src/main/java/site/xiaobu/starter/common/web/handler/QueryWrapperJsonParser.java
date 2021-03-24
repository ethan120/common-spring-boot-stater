package site.xiaobu.starter.common.web.handler;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

public class QueryWrapperJsonParser implements JsonParser {
    @Override
    public Wrapper<?> parse(String json) {
        QueryWrapper<?> wrapper = new QueryWrapper<>();
        try {
            List<Condition> conditions = JSONUtil.toList(json, Condition.class);
            conditions.forEach(condition -> {
                switch (condition.getType()) {
                    case "eq":
                        wrapper.eq(condition.getField(), condition.getValue());
                        break;
                    case "ne":
                        wrapper.ne(condition.getField(), condition.getValue());
                        break;
                    case "like":
                        wrapper.like(condition.getField(), condition.getValue());
                        break;
                    case "like_left":
                        wrapper.likeLeft(condition.getField(), condition.getValue());
                        break;
                    case "like_right":
                        wrapper.likeRight(condition.getField(), condition.getValue());
                        break;
                    case "like_not":
                        wrapper.notLike(condition.getField(), condition.getValue());
                        break;
                    case "gt":
                        wrapper.gt(condition.getField(), condition.getValue());
                        break;
                    case "lt":
                        wrapper.lt(condition.getField(), condition.getValue());
                        break;
                    case "ge":
                        wrapper.ge(condition.getField(), condition.getValue());
                        break;
                    case "le":
                        wrapper.le(condition.getField(), condition.getValue());
                        break;
                }
            });
        } catch (Exception e) {
            throw new NotSupportParseException();
        }
        return wrapper;
    }


    static class Condition {
        private String field;

        private String value;

        private String type;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
