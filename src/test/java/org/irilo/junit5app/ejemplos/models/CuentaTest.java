package org.irilo.junit5app.ejemplos.models;

import org.irilo.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class CuentaTest {
    Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
        this.cuenta = new Cuenta("Andrés", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() + " "
                + testInfo.getTestMethod().orElse(null).getName()
                + " con las etiquetas " + testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando método prueba");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("Probando atributos de cuenta corriente")
    class CuentaTestNombreYSaldo {

        @Test
        @DisplayName("Nombre")
        void testNombreCuenta() {
            testReporter.publishEntry(testInfo.getTags().toString());
            if (testInfo.getTags().contains("cuenta")) {
                testReporter.publishEntry("Hacer algo con la etiqueta cuenta");
            }
            String esperado = "Andrés";
            String real = cuenta.getPersona();
            assertNotNull(real, () -> "La cuenta no puede ser nula");
            assertEquals(esperado, real, () -> "El nombre de la cuenta no es el que se esperaba");
            assertTrue(real.equals("Andrés"), () -> "Nombre cuenta esperada debe ser igual a la real");
        }

        @Test
        @DisplayName("El saldo que no sea null, > 0 , valor esperado")
        void testSaldoCuenta() {

            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        void testReferenciaCuenta() {

            Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));
            //assertNotEquals(cuenta,cuenta2);
            assertEquals(cuenta, cuenta2);
        }

    }

    @Nested
    class CuentaOperacionesTest {
        @Tag("cuenta")
        @Test
        void testDebitoCuenta() {

            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Test
        void testCreditoCuenta() {

            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }


        @Tag("cuenta")
        @Tag("banco")
        @Test
        void testTransferirDineroCuentas() {

            Cuenta cuenta2 = new Cuenta("John", new BigDecimal("2000.12345"));

            Banco banco = new Banco();
            banco.setNombre("Banco del estado");
            banco.transferir(cuenta2, cuenta, new BigDecimal(500));
            assertEquals("1500.12345", cuenta2.getSaldo().toPlainString());
            assertEquals("1500.12345", cuenta.getSaldo().toPlainString());

        }


    }

    @Tag("cuenta")
    @Tag("error")
    @Test
    void testDineroInsuficienteExceptionCuenta() {

        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1100));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    @Tag("cuenta")
    @Tag("banco")
        //@Disabled("Está en desarrollo")
    void testRelacionBancoCuentas() {
        //fail();

        Cuenta cuenta2 = new Cuenta("John", new BigDecimal("2000.12345"));

        Banco banco = new Banco();
        banco.setNombre("Banco del Estado");
        banco.addCuenta(cuenta);
        banco.addCuenta(cuenta2);
        assertAll(() -> {
            assertEquals(2, banco.getCuentas().size());
        }, () -> {
            assertEquals("Banco del Estado", cuenta.getBanco().getNombre());
        }, () -> {
            assertEquals("Andrés", banco.getCuentas().stream()
                    .filter(c -> c.getPersona().equals("Andrés"))
                    .findFirst()
                    .get().getPersona());
        }, () -> {
            assertTrue(banco.getCuentas().stream()
                    .anyMatch(c -> c.getPersona().equals("Andrés")));
        });

    }

    @Nested
    class SistemaOperativoTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloLinuxMac() {
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void noWindows() {
        }
    }

    @Nested
    class JavaVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_21)
        void soloJdk21() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_21)
        void testNoJdk21() {
        }
    }

    @Nested
    class SystemPropertiesTest {
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = ".*21.*")
        void testJavaVersion() {
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testSolo64() {

        }

        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testNo64() {

        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "ivanr")
        void testUserName() {

        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {

        }

    }

    @Nested
    class VariableAmbienteTest {
        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + " = " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk21.0.9_10.*")
        void testJavaHome() {

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "16")
        void testProcesadores() {

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
        void testEnv() {
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "prod")
        void testEnvProdDisabled() {
        }

    }


    @Test
        //@DisplayName("Probando el saldo de la cuenta corriente, que no sea null, > 0 , valor esperado")
    void testSaldoCuentaDev() {

        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
        //@DisplayName("Probando el saldo de la cuenta corriente, que no sea null, > 0 , valor esperado")
    void testSaldoCuentaDev2() {

        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    @RepeatedTest(value = 5, name = "Repetición número {currentRepetition} de {totalRepetition}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {

        if (info.getCurrentRepetition() == 3) {
            System.out.println("Estoy en la: " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());

    }

    @Tag("param")
    @Nested
    class PruebasParametrizadasTest {
        @ParameterizedTest(name = "número {index} ejecutando con valor {0} {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
        void testDebitoCuentaValueSource(String monto) {

            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
        void testDebitoCuentaCsvSource(String index, String monto) {

            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100", "250,200", "300,300", "600,500", "750,700", "1000,1000"})
        void testDebitoCuentaCsvSource2(String saldo, String monto) {

            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto) {

            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @MethodSource("montoList")
        void testDebitoCuentaMethodSource(String monto) {

            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }

        static List<String> montoList() {
            return Arrays.asList("100", "200", "300", "500", "700", "1000");
        }
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeOutTest{
        @Test
        @Timeout(2)
        void testTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
        void testTimeout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        @Test
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(1),()->{
                TimeUnit.MILLISECONDS.sleep(900);
            });
        }
    }
}