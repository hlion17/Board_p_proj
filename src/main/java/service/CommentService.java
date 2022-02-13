package service;

import java.util.Map;

public interface CommentService {
    String write(Map<String, String> paramMap, Map<String, Object> model);
}
