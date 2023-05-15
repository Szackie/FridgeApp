package io.github.mat3e.hello;

import io.github.mat3e.lang.Lang;
import io.github.mat3e.lang.LangRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ServiceTest {
//    private static final String DEFAULT_NAME=" world!";
//    private static final String WELCOME="Hello";
//    private static final String FALLBACK_ID_WELCOME ="Hola";
//    @Test
//    public void test_ustalPowitanie_nonExistingLang_returnsGreetingWithFallbackLang() {
//        //given
//
//        var mockRepository = returnNonExistingLang();
//        var SUT = new HelloService(mockRepository);
////        when
//        var result = SUT.prepareGreeting(null,-1);
//
////    then
//        assertEquals(HelloService.FALLBACK_LANG.getWelcomeMsg()+DEFAULT_NAME, result);
//    }
//    private LangRepository returnNonExistingLang(){
//        return new LangRepository(){
//            @Override
//            public Optional<Lang> findById(Integer id) {
//                return Optional.empty();
//            }
//        };
//    }
//    @Test
//    public void test_ustalPowitanie_nullName_returnsFallbackIdName() {
//        //given
//
//        var mockRepository = alwaysReturningHelloRepository();
//        var SUT = new HelloService(mockRepository);
////        when
//        var result = SUT.prepareGreeting(null,-1);
//
////    then
//        assertEquals(WELCOME+" "+HelloService.FALLBACK_NAME+"!", result);
//    }
//    @Test
//    public void test_ustalPowitanie_name_returnsGreetingWithName() {
//        //given
//
//        var mockRepository = alwaysReturningHelloRepository();
//        var SUT = new HelloService(mockRepository);
//        String name="test";
////        when
//        var result = SUT.prepareGreeting(name,-1);
//
////    then
//        assertEquals(WELCOME+" "+name+"!", result);
//    }
//    @Test
//    public void test_ustalPowitanie_nullLang_returnsFallbackIdLang() {
//        //given
//
//        var mockRepository = fallbackLangIdRepository();
//        var SUT = new HelloService(mockRepository);
////        when
//        var result = SUT.prepareGreeting(null,null);
//
////    then
//        assertEquals(FALLBACK_ID_WELCOME+" "+HelloService.FALLBACK_NAME+"!", result);
//        }
////        @Test
////    public void test_ustalPowitanie_textLang_returnsFallbackIdLang() {
////        //given
////
////        var mockRepository = fallbackLangIdRepository();
////        var SUT = new HelloService(mockRepository);
//////        when
////        var result = SUT.prepareGreeting(null,"abc");
////
//////    then
////        assertEquals(FALLBACK_ID_WELCOME+" "+HelloService.FALLBACK_NAME+"!", result);
////        }
//
//
//    private LangRepository fallbackLangIdRepository() {
//        return new LangRepository() {
//            @Override
//            public Optional<Lang> findById(Integer id) {
//                if (id.equals(HelloService.FALLBACK_LANG.getId())) {
//                    return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
//                }
//                return Optional.empty();
//            }
//        };
//    }
//
//    private LangRepository alwaysReturningHelloRepository() {
//            return new LangRepository() {
//                @Override
//                public Optional<Lang> findById(Integer id) {
//
//                    return Optional.of(new Lang(null, WELCOME, null));
//                }
//            };
//        }
}
