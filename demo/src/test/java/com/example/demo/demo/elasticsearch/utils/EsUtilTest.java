package com.example.demo.demo.elasticsearch.utils;

/*
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

*/
/**
 * @author Zhengyn
 * @description
 * @create 21/2/25 11:24
 *//*

@SpringBootTest
class EsUtilTest {

    @Autowired
    EsUtil esUtil;

    @Autowired
    RestHighLevelClient esClient;

    String myIndex = "my-index";
    String bookIndex = "book-index";

    @Test
    public void test1() {
        File file = new File("src/main/resources/es.txt");
        System.out.println(file.getAbsolutePath());
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = bReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    void indexExist() throws Exception {
        final boolean b = esUtil.indexExist(myIndex);
        System.err.println(b);

    }

    @Test
    void insertOrUpdateOne() {
        final IndexResponse indexResponse = esUtil.insertOrUpdateOne(bookIndex, new EsEntity<>("3", new Book(55, "人类简史")));
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.getResult());
    }

    @Test
    void insertBatch() {
    }

    @Test
    void search() throws IOException {
        final MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "简史");
        final HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name").preTags("-------").postTags("=======");
        final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        final SearchSourceBuilder highlighterQuery = searchSourceBuilder.query(matchQueryBuilder).highlighter(highlightBuilder);
        SearchRequest request = new SearchRequest(bookIndex,myIndex);
        request.source(highlighterQuery);
        final SearchResponse search = EsUtil.esClient.search(request, RequestOptions.DEFAULT);
        System.out.println(search.toString());
    }

    @Test
    void deleteIndex() {
    }

    @Test
    void deleteByQuery() {
    }

    @Test
    void deleteBatch() {
    }
}*/
