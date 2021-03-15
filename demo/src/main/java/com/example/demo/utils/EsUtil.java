package com.example.demo.utils;

/*
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

*/
/**
 * @author Zhengyn
 * @description
 * @create 21/2/24 17:52
 *//*

@Component
@Slf4j
public class EsUtil {
    @Value("114.215.211.160")
    public String host;
    @Value("9200")
    public int port;
    @Value("http")
    public String scheme;

    public static final String INDEX_NAME = "my-index";

    public static String CREATE_INDEX;
    public static RestHighLevelClient esClient = null;

    private static String readFileToString() {
        File file = new File("src/main/resources/es.txt");
        log.info(file.getAbsolutePath());
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = bReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    @PostConstruct
    public void init() {
        CREATE_INDEX = readFileToString();
        log.info("CREATE_INDEX = " + CREATE_INDEX);
        try {
            if (esClient != null) {
                esClient.close();
            }
            esClient = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, scheme)));
            if (this.indexExist(INDEX_NAME)) {
                return;
            }
            CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
            request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
            request.mapping(CREATE_INDEX, XContentType.JSON);
            CreateIndexResponse res = esClient.indices().create(request, RequestOptions.DEFAULT);
            if (!res.isAcknowledged()) {
                throw new RuntimeException("初始化失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public boolean indexExist(String index) throws Exception {
        GetIndexRequest request = new GetIndexRequest(index);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);
        return esClient.indices().exists(request, RequestOptions.DEFAULT);
    }

    public IndexResponse insertOrUpdateOne(String index, EsEntity entity) {
        IndexRequest request = new IndexRequest(index);
        request.id(entity.getId());
        request.source(JSON.toJSONString(entity.getData()), XContentType.JSON);
        try {
            return esClient.index(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BulkResponse insertBatch(String index, List<EsEntity> list) {
        BulkRequest request = new BulkRequest();
        for (EsEntity item : list) {
            String json = JSON.toJSONString(item.getData());
            String id = item.getId();
            IndexRequest indexRequest = new IndexRequest(index).id(id).source(json, XContentType.JSON);
            request.add(indexRequest);
        }
        try {
            return esClient.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> search(String index, SearchSourceBuilder searchSourceBuilder, Class<T> resultClass) {
        SearchRequest request = new SearchRequest(index);
        request.source(searchSourceBuilder);
        try {
            SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits1 = response.getHits();
            SearchHit[] hits2 = hits1.getHits();
            List<T> retList = new ArrayList<>(hits2.length);
            for (SearchHit hit : hits2) {
                String strJson = hit.getSourceAsString();
                retList.add(JSON.parseObject(strJson, resultClass));
            }
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public AcknowledgedResponse deleteIndex(String index) {
        try {
            IndicesClient indicesClient = esClient.indices();
            DeleteIndexRequest request = new DeleteIndexRequest(index);
            return indicesClient.delete(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BulkByScrollResponse deleteByQuery(String index, QueryBuilder builder) {
        DeleteByQueryRequest request = new DeleteByQueryRequest(index);
        request.setQuery(builder);
        request.setBatchSize(10000);
        request.setConflicts("proceed");
        try {
            return esClient.deleteByQuery(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> BulkResponse deleteBatch(String index, Collection<T> idList) {
        BulkRequest request = new BulkRequest();
        for (T t : idList) {
            request.add(new DeleteRequest(index, t.toString()));
        }
        try {
            return esClient.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void destory() throws IOException {
        esClient.close();
        log.info("EsClient 资源关闭");
    }
}
*/

