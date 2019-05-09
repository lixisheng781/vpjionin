package com.vpclub.mybatis;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MyBatis执行sql工具
 *
 */
public class MybatisSqlHelper {

    private final MSUtils msUtils;

    private final SqlSession sqlSession;


    /**
     * 构造方法，默认缓存MappedStatement
     *
     * @param sqlSession
     */
    public MybatisSqlHelper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.msUtils = new MSUtils(sqlSession.getConfiguration());
    }

    /**
     * 获取List中最多只有一个的数据
     *
     * @param list List结果
     * @param <T>  泛型类型
     * @return
     */
    private <T> T getOne(List<T> list) {
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() > 1) {
            throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        } else {
            return null;
        }
    }

    /**
     * 查询返回一个结果，多个结果时抛出异常
     *
     * @param sql 执行的sql
     * @return
     */
    public Map<String, Object> selectOne(String sql) {
        List<Map<String, Object>> list = selectList(sql);
        return getOne(list);
    }

    /**
     * 查询返回一个结果，多个结果时抛出异常
     *
     * @param sql   执行的sql
     * @param params 参数
     * @return
     */
    public Map<String, Object> selectOne(String sql, Object params) {
        List<Map<String, Object>> list = selectList(sql, params);
        return getOne(list);
    }

    /**
     * 查询返回一个结果，多个结果时抛出异常
     *
     * @param sql        执行的sql
     * @param resultType 返回的结果类型
     * @param <T>        泛型类型
     * @return
     */
    public <T> T selectOne(String sql, Class<T> resultType) {
        List<T> list = selectList(sql, resultType);
        return getOne(list);
    }

    /**
     * 查询返回一个结果，多个结果时抛出异常
     *
     * @param sql        执行的sql
     * @param params     参数
     * @param resultType 返回的结果类型
     * @param <T>        泛型类型
     * @return
     */
    public <T> T selectOne(String sql, Object params, Class<T> resultType) {
        List<T> list = selectList(sql, params, resultType);
        return getOne(list);
    }


    /**
     * 查询返回Cursor<Map<String, Object>>
     *
     * @param sql 执行的sql
     * @return
     */
    public Cursor<Map<String, Object>> selectCursor(String sql) {
        String msId = msUtils.selectStream(sql);
        return sqlSession.selectCursor(msId);
    }

    /**
     * 查询返回List<Map<String, Object>>
     *
     * @param sql   执行的sql
     * @param params 参数
     * @return
     */
    public Cursor<Map<String, Object>> selectCursor(String sql, Object params) {
        Class<?> parameterType = params != null ? params.getClass() : null;
        String msId = msUtils.selectStreamDynamic(sql, parameterType);
        return sqlSession.selectCursor(msId, params);
    }

    /**
     * 查询返回指定的结果类型
     *
     * @param sql        执行的sql
     * @param resultType 返回的结果类型
     * @param <T>        泛型类型
     * @return
     */
    public <T> Cursor<T> selectCursor(String sql, Class<T> resultType) {
        String msId;
        if (resultType == null) {
            msId = msUtils.selectStream(sql);
        } else {
            msId = msUtils.selectStream(sql, resultType);
        }
        return sqlSession.selectCursor(msId);
    }

    /**
     * 查询返回指定的结果类型
     *
     * @param sql        执行的sql
     * @param params      参数
     * @param resultType 返回的结果类型
     * @param <T>        泛型类型
     * @return
     */
    public <T> Cursor<T> selectCursor(String sql, Object params, Class<T> resultType) {
        String msId;
        Class<?> parameterType = params != null ? params.getClass() : null;
        if (resultType == null) {
            msId = msUtils.selectStreamDynamic(sql, parameterType);
        } else {
            msId = msUtils.selectStreamDynamic(sql, parameterType, resultType);
        }
        return sqlSession.selectCursor(msId, params);
    }


    /**
     * 查询返回List<Map<String, Object>>
     *
     * @param sql 执行的sql
     * @return
     */
    public List<Map<String, Object>> selectList(String sql) {
        String msId = msUtils.select(sql);
        return sqlSession.selectList(msId);
    }

    /**
     * 查询返回List<Map<String, Object>>
     *
     * @param sql   执行的sql
     * @param params 参数
     * @return
     */
    public List<Map<String, Object>> selectList(String sql, Object params) {
        Class<?> parameterType = params != null ? params.getClass() : null;
        String msId = msUtils.selectDynamic(sql, parameterType);
        return sqlSession.selectList(msId, params);
    }

    /**
     * 查询返回指定的结果类型
     *
     * @param sql        执行的sql
     * @param resultType 返回的结果类型
     * @param <T>        泛型类型
     * @return
     */
    public <T> List<T> selectList(String sql, Class<T> resultType) {
        String msId;
        if (resultType == null) {
            msId = msUtils.select(sql);
        } else {
            msId = msUtils.select(sql, resultType);
        }
        return sqlSession.selectList(msId);
    }

    /**
     * 查询返回指定的结果类型
     *
     * @param sql        执行的sql
     * @param params      参数
     * @param resultType 返回的结果类型
     * @param <T>        泛型类型
     * @return
     */
    public <T> List<T> selectList(String sql, Object params, Class<T> resultType) {
        String msId;
        Class<?> parameterType = params != null ? params.getClass() : null;
        if (resultType == null) {
            msId = msUtils.selectDynamic(sql, parameterType);
        } else {
            msId = msUtils.selectDynamic(sql, parameterType, resultType);
        }
        return sqlSession.selectList(msId, params);
    }

    /**
     * 插入数据
     *
     * @param sql 执行的sql
     * @return
     */
    public int insert(String sql) {
        String msId = msUtils.insert(sql);
        return sqlSession.insert(msId);
    }

    /**
     * 插入数据
     *
     * @param sql   执行的sql
     * @param params 参数
     * @return
     */
    public int insert(String sql, Object params) {
        Class<?> parameterType = params != null ? params.getClass() : null;
        String msId = msUtils.insertDynamic(sql, parameterType);
        return sqlSession.insert(msId, params);
    }

    /**
     * 更新数据
     *
     * @param sql 执行的sql
     * @return
     */
    public int update(String sql) {
        String msId = msUtils.update(sql);
        return sqlSession.update(msId);
    }

    /**
     * 更新数据
     *
     * @param sql   执行的sql
     * @param params 参数
     * @return
     */
    public int update(String sql, Object params) {
        Class<?> parameterType = params != null ? params.getClass() : null;
        String msId = msUtils.updateDynamic(sql, parameterType);
        return sqlSession.update(msId, params);
    }

    /**
     * 删除数据
     *
     * @param sql 执行的sql
     * @return
     */
    public int delete(String sql) {
        String msId = msUtils.delete(sql);
        return sqlSession.delete(msId);
    }

    /**
     * 删除数据
     *
     * @param sql   执行的sql
     * @param params 参数
     * @return
     */
    public int delete(String sql, Object params) {
        Class<?> parameterType = params != null ? params.getClass() : null;
        String msId = msUtils.deleteDynamic(sql, parameterType);
        return sqlSession.delete(msId, params);
    }



    private class MSUtils {

        private Configuration configuration;

        private LanguageDriver languageDriver;

        private MSUtils(Configuration configuration) {
            this.configuration = configuration;
            languageDriver = configuration.getDefaultScriptingLanuageInstance();
        }

        /**
         * 创建MSID
         *
         * @param sql 执行的sql
         * @param sql 执行的sqlCommandType
         * @return
         */
        private String newMsId(String sql, SqlCommandType sqlCommandType) {
            StringBuilder msIdBuilder = new StringBuilder(sqlCommandType.toString());
            msIdBuilder.append(".").append(sql.hashCode());
            return msIdBuilder.toString();
        }

        /**
         * 是否已经存在该ID
         *
         * @param msId
         * @return
         */
        private boolean hasMappedStatement(String msId) {
            return configuration.hasStatement(msId, false);
        }

        /**
         * 创建一个查询的MS
         *
         * @param msId
         * @param sqlSource  执行的sqlSource
         * @param resultType 返回的结果类型
         */
        private void newSelectMappedStatement(String msId, SqlSource sqlSource, final Class<?> resultType, Integer fetchSize) {
            MappedStatement ms = new MappedStatement.Builder(configuration, msId, sqlSource, SqlCommandType.SELECT)
                    .fetchSize(fetchSize)
                    .resultMaps(new ArrayList<ResultMap>() {
                        {
                            add(new ResultMap.Builder(configuration, "defaultResultMap", resultType, new ArrayList<ResultMapping>(0)).build());
                        }
                    })
                    .build();
            //缓存
            configuration.addMappedStatement(ms);
        }

        /**
         * 创建一个简单的MS
         *
         * @param msId
         * @param sqlSource      执行的sqlSource
         * @param sqlCommandType 执行的sqlCommandType
         */
        private void newUpdateMappedStatement(String msId, SqlSource sqlSource, SqlCommandType sqlCommandType) {
            MappedStatement ms = new MappedStatement.Builder(configuration, msId, sqlSource, sqlCommandType)
                    .resultMaps(new ArrayList<ResultMap>() {
                        {
                            add(new ResultMap.Builder(configuration, "defaultResultMap", int.class, new ArrayList<ResultMapping>(0)).build());
                        }
                    })
                    .build();
            //缓存
            configuration.addMappedStatement(ms);
        }

        private String select(String sql) {
            return select(sql,Map.class,null);
        }

        private String select(String sql,Class<?> resultType) {
            return select(sql, resultType,null);
        }

        private String selectStream(String sql) {
            return select(sql, Map.class, Integer.MIN_VALUE);
        }

        private String selectStream(String sql, Class<?> resultType) {
            return select(sql, resultType, Integer.MIN_VALUE);
        }

        private String select(String sql, Class<?> resultType, Integer fetchSize) {
            String msId = newMsId(resultType + sql, SqlCommandType.SELECT);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
            newSelectMappedStatement(msId, sqlSource, resultType, fetchSize);
            return msId;
        }


        private String selectDynamic(String sql, Class<?> parameterType) {
            return selectDynamic(sql, parameterType, Map.class,null);
        }

        private String selectDynamic(String sql, Class<?> parameterType, Class<?> resultType) {
            return selectDynamic(sql, parameterType, resultType,null);
        }

        private String selectStreamDynamic(String sql, Class<?> parameterType) {
            return selectDynamic(sql, parameterType, Map.class, Integer.MIN_VALUE);
        }

        private String selectStreamDynamic(String sql, Class<?> parameterType, Class<?> resultType) {
            return selectDynamic(sql, parameterType, resultType, Integer.MIN_VALUE);
        }

        private String selectDynamic(String sql, Class<?> parameterType, Class<?> resultType,Integer fetchSize) {
            String msId = newMsId(resultType + sql + parameterType, SqlCommandType.SELECT);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
            newSelectMappedStatement(msId, sqlSource, resultType, fetchSize);
            return msId;
        }




        private String insert(String sql) {
            String msId = newMsId(sql, SqlCommandType.INSERT);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
            newUpdateMappedStatement(msId, sqlSource, SqlCommandType.INSERT);
            return msId;
        }

        private String insertDynamic(String sql, Class<?> parameterType) {
            String msId = newMsId(sql + parameterType, SqlCommandType.INSERT);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
            newUpdateMappedStatement(msId, sqlSource, SqlCommandType.INSERT);
            return msId;
        }

        private String update(String sql) {
            String msId = newMsId(sql, SqlCommandType.UPDATE);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
            newUpdateMappedStatement(msId, sqlSource, SqlCommandType.UPDATE);
            return msId;
        }

        private String updateDynamic(String sql, Class<?> parameterType) {
            String msId = newMsId(sql + parameterType, SqlCommandType.UPDATE);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
            newUpdateMappedStatement(msId, sqlSource, SqlCommandType.UPDATE);
            return msId;
        }

        private String delete(String sql) {
            String msId = newMsId(sql, SqlCommandType.DELETE);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
            newUpdateMappedStatement(msId, sqlSource, SqlCommandType.DELETE);
            return msId;
        }

        private String deleteDynamic(String sql, Class<?> parameterType) {
            String msId = newMsId(sql + parameterType, SqlCommandType.DELETE);
            if (hasMappedStatement(msId)) {
                return msId;
            }
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
            newUpdateMappedStatement(msId, sqlSource, SqlCommandType.DELETE);
            return msId;
        }
    }
}
