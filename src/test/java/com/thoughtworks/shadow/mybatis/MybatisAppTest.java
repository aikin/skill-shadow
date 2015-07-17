package com.thoughtworks.shadow.mybatis;

import com.thoughtworks.shadow.mybatis.mapper.ProductMapper;
import com.thoughtworks.shadow.mybatis.model.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;


import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MybatisAppTest {

    protected SqlSessionFactory sqlSessionFactory;


//    @BeforeClass // like Before in mocha

    @Before     // like BeforeEach in mocha
    public void setUp() throws IOException {

        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @After
    public void tearDown() throws IOException {
        sqlSessionFactory = null;
    }
    
    @Test
    public void should_select_product() {

        SqlSession session = sqlSessionFactory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        Product product = mapper.selectProductById(1);
        assertThat(product.getDescription(), is("Lamp"));
        assertThat(product.getPrice(), is(5.78F));
    }

}