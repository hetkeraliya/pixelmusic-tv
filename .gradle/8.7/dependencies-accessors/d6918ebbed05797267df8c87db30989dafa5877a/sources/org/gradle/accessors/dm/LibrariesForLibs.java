package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AccompanistLibraryAccessors laccForAccompanistLibraryAccessors = new AccompanistLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ApacheLibraryAccessors laccForApacheLibraryAccessors = new ApacheLibraryAccessors(owner);
    private final BouncycastleLibraryAccessors laccForBouncycastleLibraryAccessors = new BouncycastleLibraryAccessors(owner);
    private final CheckerLibraryAccessors laccForCheckerLibraryAccessors = new CheckerLibraryAccessors(owner);
    private final CoilLibraryAccessors laccForCoilLibraryAccessors = new CoilLibraryAccessors(owner);
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final ConverterLibraryAccessors laccForConverterLibraryAccessors = new ConverterLibraryAccessors(owner);
    private final CredentialsLibraryAccessors laccForCredentialsLibraryAccessors = new CredentialsLibraryAccessors(owner);
    private final DesugarLibraryAccessors laccForDesugarLibraryAccessors = new DesugarLibraryAccessors(owner);
    private final DuktapeLibraryAccessors laccForDuktapeLibraryAccessors = new DuktapeLibraryAccessors(owner);
    private final FuelLibraryAccessors laccForFuelLibraryAccessors = new FuelLibraryAccessors(owner);
    private final GoogleLibraryAccessors laccForGoogleLibraryAccessors = new GoogleLibraryAccessors(owner);
    private final HiltLibraryAccessors laccForHiltLibraryAccessors = new HiltLibraryAccessors(owner);
    private final HorologistLibraryAccessors laccForHorologistLibraryAccessors = new HorologistLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final KtorLibraryAccessors laccForKtorLibraryAccessors = new KtorLibraryAccessors(owner);
    private final KuromojiLibraryAccessors laccForKuromojiLibraryAccessors = new KuromojiLibraryAccessors(owner);
    private final LoggingLibraryAccessors laccForLoggingLibraryAccessors = new LoggingLibraryAccessors(owner);
    private final NettyLibraryAccessors laccForNettyLibraryAccessors = new NettyLibraryAccessors(owner);
    private final NewpipeLibraryAccessors laccForNewpipeLibraryAccessors = new NewpipeLibraryAccessors(owner);
    private final OkhttpLibraryAccessors laccForOkhttpLibraryAccessors = new OkhttpLibraryAccessors(owner);
    private final Pinyin4jLibraryAccessors laccForPinyin4jLibraryAccessors = new Pinyin4jLibraryAccessors(owner);
    private final PlayLibraryAccessors laccForPlayLibraryAccessors = new PlayLibraryAccessors(owner);
    private final ProtobufLibraryAccessors laccForProtobufLibraryAccessors = new ProtobufLibraryAccessors(owner);
    private final PytorchLibraryAccessors laccForPytorchLibraryAccessors = new PytorchLibraryAccessors(owner);
    private final SmoothLibraryAccessors laccForSmoothLibraryAccessors = new SmoothLibraryAccessors(owner);
    private final SpleeterLibraryAccessors laccForSpleeterLibraryAccessors = new SpleeterLibraryAccessors(owner);
    private final TensorflowLibraryAccessors laccForTensorflowLibraryAccessors = new TensorflowLibraryAccessors(owner);
    private final VorbisjavaLibraryAccessors laccForVorbisjavaLibraryAccessors = new VorbisjavaLibraryAccessors(owner);
    private final WavyLibraryAccessors laccForWavyLibraryAccessors = new WavyLibraryAccessors(owner);
    private final WearLibraryAccessors laccForWearLibraryAccessors = new WearLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>brotli</b> with <b>org.brotli:dec</b> coordinates and
     * with version <b>0.1.2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getBrotli() {
        return create("brotli");
    }

    /**
     * Dependency provider for <b>capturable</b> with <b>dev.shreyaspatil:capturable</b> coordinates and
     * with version reference <b>capturable</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCapturable() {
        return create("capturable");
    }

    /**
     * Dependency provider for <b>codeview</b> with <b>io.github.amrdeveloper:codeview</b> coordinates and
     * with version reference <b>codeview</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getCodeview() {
        return create("codeview");
    }

    /**
     * Dependency provider for <b>generativeai</b> with <b>com.google.ai.client.generativeai:generativeai</b> coordinates and
     * with version reference <b>generativeai</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGenerativeai() {
        return create("generativeai");
    }

    /**
     * Dependency provider for <b>googleid</b> with <b>com.google.android.libraries.identity.googleid:googleid</b> coordinates and
     * with version reference <b>googleid</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGoogleid() {
        return create("googleid");
    }

    /**
     * Dependency provider for <b>gson</b> with <b>com.google.code.gson:gson</b> coordinates and
     * with version reference <b>gson</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGson() {
        return create("gson");
    }

    /**
     * Dependency provider for <b>jaudiotagger</b> with <b>net.jthink:jaudiotagger</b> coordinates and
     * with version reference <b>jaudiotagger</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJaudiotagger() {
        return create("jaudiotagger");
    }

    /**
     * Dependency provider for <b>jdom2</b> with <b>org.jdom:jdom2</b> coordinates and
     * with version reference <b>jdom2</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJdom2() {
        return create("jdom2");
    }

    /**
     * Dependency provider for <b>jose4j</b> with <b>org.bitbucket.b_c:jose4j</b> coordinates and
     * with version reference <b>jose4j</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJose4j() {
        return create("jose4j");
    }

    /**
     * Dependency provider for <b>junitplatformlauncher</b> with <b>org.junit.platform:junit-platform-launcher</b> coordinates and
     * with version reference <b>junitJupiter</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJunitplatformlauncher() {
        return create("junitplatformlauncher");
    }

    /**
     * Dependency provider for <b>lifecycleprocess</b> with <b>androidx.lifecycle:lifecycle-process</b> coordinates and
     * with version reference <b>lifecycleRuntimeKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getLifecycleprocess() {
        return create("lifecycleprocess");
    }

    /**
     * Dependency provider for <b>material</b> with <b>com.google.android.material:material</b> coordinates and
     * with version reference <b>material</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMaterial() {
        return create("material");
    }

    /**
     * Dependency provider for <b>material3</b> with <b>androidx.compose.material3:material3</b> coordinates and
     * with version reference <b>material3</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMaterial3() {
        return create("material3");
    }

    /**
     * Dependency provider for <b>mockk</b> with <b>io.mockk:mockk</b> coordinates and
     * with version reference <b>mockk</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMockk() {
        return create("mockk");
    }

    /**
     * Dependency provider for <b>newpipeextractor</b> with <b>com.github.TeamNewPipe:NewPipeExtractor</b> coordinates and
     * with version reference <b>newpipeextractor</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getNewpipeextractor() {
        return create("newpipeextractor");
    }

    /**
     * Dependency provider for <b>re2j</b> with <b>com.google.re2j:re2j</b> coordinates and
     * with version <b>1.8</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRe2j() {
        return create("re2j");
    }

    /**
     * Dependency provider for <b>reorderable</b> with <b>org.burnoutcrew.composereorderable:reorderable</b> coordinates and
     * with version reference <b>reorderable</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getReorderable() {
        return create("reorderable");
    }

    /**
     * Dependency provider for <b>reorderables</b> with <b>sh.calvin.reorderable:reorderable</b> coordinates and
     * with version reference <b>reorderables</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getReorderables() {
        return create("reorderables");
    }

    /**
     * Dependency provider for <b>retrofit</b> with <b>com.squareup.retrofit2:retrofit</b> coordinates and
     * with version reference <b>retrofit</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRetrofit() {
        return create("retrofit");
    }

    /**
     * Dependency provider for <b>rhino</b> with <b>org.mozilla:rhino</b> coordinates and
     * with version <b>1.9.1</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getRhino() {
        return create("rhino");
    }

    /**
     * Dependency provider for <b>taglib</b> with <b>io.github.kyant0:taglib</b> coordinates and
     * with version reference <b>taglib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTaglib() {
        return create("taglib");
    }

    /**
     * Dependency provider for <b>tdlib</b> with <b>com.github.tdlibx:td</b> coordinates and
     * with version <b>1.8.56</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTdlib() {
        return create("tdlib");
    }

    /**
     * Dependency provider for <b>timber</b> with <b>com.jakewharton.timber:timber</b> coordinates and
     * with version reference <b>timber</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTimber() {
        return create("timber");
    }

    /**
     * Dependency provider for <b>truth</b> with <b>com.google.truth:truth</b> coordinates and
     * with version reference <b>truth</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTruth() {
        return create("truth");
    }

    /**
     * Dependency provider for <b>turbine</b> with <b>app.cash.turbine:turbine</b> coordinates and
     * with version reference <b>turbine</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getTurbine() {
        return create("turbine");
    }

    /**
     * Dependency provider for <b>worktesting</b> with <b>androidx.work:work-testing</b> coordinates and
     * with version reference <b>workRuntimeKtx</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getWorktesting() {
        return create("worktesting");
    }

    /**
     * Group of libraries at <b>accompanist</b>
     */
    public AccompanistLibraryAccessors getAccompanist() {
        return laccForAccompanistLibraryAccessors;
    }

    /**
     * Group of libraries at <b>androidx</b>
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>apache</b>
     */
    public ApacheLibraryAccessors getApache() {
        return laccForApacheLibraryAccessors;
    }

    /**
     * Group of libraries at <b>bouncycastle</b>
     */
    public BouncycastleLibraryAccessors getBouncycastle() {
        return laccForBouncycastleLibraryAccessors;
    }

    /**
     * Group of libraries at <b>checker</b>
     */
    public CheckerLibraryAccessors getChecker() {
        return laccForCheckerLibraryAccessors;
    }

    /**
     * Group of libraries at <b>coil</b>
     */
    public CoilLibraryAccessors getCoil() {
        return laccForCoilLibraryAccessors;
    }

    /**
     * Group of libraries at <b>commons</b>
     */
    public CommonsLibraryAccessors getCommons() {
        return laccForCommonsLibraryAccessors;
    }

    /**
     * Group of libraries at <b>compose</b>
     */
    public ComposeLibraryAccessors getCompose() {
        return laccForComposeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>converter</b>
     */
    public ConverterLibraryAccessors getConverter() {
        return laccForConverterLibraryAccessors;
    }

    /**
     * Group of libraries at <b>credentials</b>
     */
    public CredentialsLibraryAccessors getCredentials() {
        return laccForCredentialsLibraryAccessors;
    }

    /**
     * Group of libraries at <b>desugar</b>
     */
    public DesugarLibraryAccessors getDesugar() {
        return laccForDesugarLibraryAccessors;
    }

    /**
     * Group of libraries at <b>duktape</b>
     */
    public DuktapeLibraryAccessors getDuktape() {
        return laccForDuktapeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>fuel</b>
     */
    public FuelLibraryAccessors getFuel() {
        return laccForFuelLibraryAccessors;
    }

    /**
     * Group of libraries at <b>google</b>
     */
    public GoogleLibraryAccessors getGoogle() {
        return laccForGoogleLibraryAccessors;
    }

    /**
     * Group of libraries at <b>hilt</b>
     */
    public HiltLibraryAccessors getHilt() {
        return laccForHiltLibraryAccessors;
    }

    /**
     * Group of libraries at <b>horologist</b>
     */
    public HorologistLibraryAccessors getHorologist() {
        return laccForHorologistLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlin</b>
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlinx</b>
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>ktor</b>
     */
    public KtorLibraryAccessors getKtor() {
        return laccForKtorLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kuromoji</b>
     */
    public KuromojiLibraryAccessors getKuromoji() {
        return laccForKuromojiLibraryAccessors;
    }

    /**
     * Group of libraries at <b>logging</b>
     */
    public LoggingLibraryAccessors getLogging() {
        return laccForLoggingLibraryAccessors;
    }

    /**
     * Group of libraries at <b>netty</b>
     */
    public NettyLibraryAccessors getNetty() {
        return laccForNettyLibraryAccessors;
    }

    /**
     * Group of libraries at <b>newpipe</b>
     */
    public NewpipeLibraryAccessors getNewpipe() {
        return laccForNewpipeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>okhttp</b>
     */
    public OkhttpLibraryAccessors getOkhttp() {
        return laccForOkhttpLibraryAccessors;
    }

    /**
     * Group of libraries at <b>pinyin4j</b>
     */
    public Pinyin4jLibraryAccessors getPinyin4j() {
        return laccForPinyin4jLibraryAccessors;
    }

    /**
     * Group of libraries at <b>play</b>
     */
    public PlayLibraryAccessors getPlay() {
        return laccForPlayLibraryAccessors;
    }

    /**
     * Group of libraries at <b>protobuf</b>
     */
    public ProtobufLibraryAccessors getProtobuf() {
        return laccForProtobufLibraryAccessors;
    }

    /**
     * Group of libraries at <b>pytorch</b>
     */
    public PytorchLibraryAccessors getPytorch() {
        return laccForPytorchLibraryAccessors;
    }

    /**
     * Group of libraries at <b>smooth</b>
     */
    public SmoothLibraryAccessors getSmooth() {
        return laccForSmoothLibraryAccessors;
    }

    /**
     * Group of libraries at <b>spleeter</b>
     */
    public SpleeterLibraryAccessors getSpleeter() {
        return laccForSpleeterLibraryAccessors;
    }

    /**
     * Group of libraries at <b>tensorflow</b>
     */
    public TensorflowLibraryAccessors getTensorflow() {
        return laccForTensorflowLibraryAccessors;
    }

    /**
     * Group of libraries at <b>vorbisjava</b>
     */
    public VorbisjavaLibraryAccessors getVorbisjava() {
        return laccForVorbisjavaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>wavy</b>
     */
    public WavyLibraryAccessors getWavy() {
        return laccForWavyLibraryAccessors;
    }

    /**
     * Group of libraries at <b>wear</b>
     */
    public WearLibraryAccessors getWear() {
        return laccForWearLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AccompanistLibraryAccessors extends SubDependencyFactory {

        public AccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>drawablepainter</b> with <b>com.google.accompanist:accompanist-drawablepainter</b> coordinates and
         * with version reference <b>accompanistDrawablepainter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDrawablepainter() {
            return create("accompanist.drawablepainter");
        }

        /**
         * Dependency provider for <b>permissions</b> with <b>com.google.accompanist:accompanist-permissions</b> coordinates and
         * with version reference <b>accompanist</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPermissions() {
            return create("accompanist.permissions");
        }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxAppLibraryAccessors laccForAndroidxAppLibraryAccessors = new AndroidxAppLibraryAccessors(owner);
        private final AndroidxBenchmarkLibraryAccessors laccForAndroidxBenchmarkLibraryAccessors = new AndroidxBenchmarkLibraryAccessors(owner);
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxConstraintlayoutLibraryAccessors laccForAndroidxConstraintlayoutLibraryAccessors = new AndroidxConstraintlayoutLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxDatastoreLibraryAccessors laccForAndroidxDatastoreLibraryAccessors = new AndroidxDatastoreLibraryAccessors(owner);
        private final AndroidxEspressoLibraryAccessors laccForAndroidxEspressoLibraryAccessors = new AndroidxEspressoLibraryAccessors(owner);
        private final AndroidxGlanceLibraryAccessors laccForAndroidxGlanceLibraryAccessors = new AndroidxGlanceLibraryAccessors(owner);
        private final AndroidxGraphicsLibraryAccessors laccForAndroidxGraphicsLibraryAccessors = new AndroidxGraphicsLibraryAccessors(owner);
        private final AndroidxHiltLibraryAccessors laccForAndroidxHiltLibraryAccessors = new AndroidxHiltLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxMaterialLibraryAccessors laccForAndroidxMaterialLibraryAccessors = new AndroidxMaterialLibraryAccessors(owner);
        private final AndroidxMediaLibraryAccessors laccForAndroidxMediaLibraryAccessors = new AndroidxMediaLibraryAccessors(owner);
        private final AndroidxMedia3LibraryAccessors laccForAndroidxMedia3LibraryAccessors = new AndroidxMedia3LibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxPagingLibraryAccessors laccForAndroidxPagingLibraryAccessors = new AndroidxPagingLibraryAccessors(owner);
        private final AndroidxPaletteLibraryAccessors laccForAndroidxPaletteLibraryAccessors = new AndroidxPaletteLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);
        private final AndroidxSecurityLibraryAccessors laccForAndroidxSecurityLibraryAccessors = new AndroidxSecurityLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);
        private final AndroidxUiLibraryAccessors laccForAndroidxUiLibraryAccessors = new AndroidxUiLibraryAccessors(owner);
        private final AndroidxWorkLibraryAccessors laccForAndroidxWorkLibraryAccessors = new AndroidxWorkLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>animation</b> with <b>androidx.compose.animation:animation</b> coordinates and
         * with version reference <b>animation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnimation() {
            return create("androidx.animation");
        }

        /**
         * Dependency provider for <b>appcompat</b> with <b>androidx.appcompat:appcompat</b> coordinates and
         * with version reference <b>appcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppcompat() {
            return create("androidx.appcompat");
        }

        /**
         * Dependency provider for <b>foundation</b> with <b>androidx.compose.foundation:foundation</b> coordinates and
         * with version reference <b>foundation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFoundation() {
            return create("androidx.foundation");
        }

        /**
         * Dependency provider for <b>junit</b> with <b>androidx.test.ext:junit</b> coordinates and
         * with version reference <b>junitVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("androidx.junit");
        }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.compose.material3:material3</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("androidx.material3");
        }

        /**
         * Dependency provider for <b>mediarouter</b> with <b>androidx.mediarouter:mediarouter</b> coordinates and
         * with version reference <b>mediarouterVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMediarouter() {
            return create("androidx.mediarouter");
        }

        /**
         * Dependency provider for <b>profileinstaller</b> with <b>androidx.profileinstaller:profileinstaller</b> coordinates and
         * with version reference <b>profileinstaller</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProfileinstaller() {
            return create("androidx.profileinstaller");
        }

        /**
         * Dependency provider for <b>uiautomator</b> with <b>androidx.test.uiautomator:uiautomator</b> coordinates and
         * with version reference <b>uiautomator</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUiautomator() {
            return create("androidx.uiautomator");
        }

        /**
         * Group of libraries at <b>androidx.activity</b>
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.app</b>
         */
        public AndroidxAppLibraryAccessors getApp() {
            return laccForAndroidxAppLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.benchmark</b>
         */
        public AndroidxBenchmarkLibraryAccessors getBenchmark() {
            return laccForAndroidxBenchmarkLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.compose</b>
         */
        public AndroidxComposeLibraryAccessors getCompose() {
            return laccForAndroidxComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.constraintlayout</b>
         */
        public AndroidxConstraintlayoutLibraryAccessors getConstraintlayout() {
            return laccForAndroidxConstraintlayoutLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.core</b>
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.datastore</b>
         */
        public AndroidxDatastoreLibraryAccessors getDatastore() {
            return laccForAndroidxDatastoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.espresso</b>
         */
        public AndroidxEspressoLibraryAccessors getEspresso() {
            return laccForAndroidxEspressoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.glance</b>
         */
        public AndroidxGlanceLibraryAccessors getGlance() {
            return laccForAndroidxGlanceLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.graphics</b>
         */
        public AndroidxGraphicsLibraryAccessors getGraphics() {
            return laccForAndroidxGraphicsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.hilt</b>
         */
        public AndroidxHiltLibraryAccessors getHilt() {
            return laccForAndroidxHiltLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle</b>
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.material</b>
         */
        public AndroidxMaterialLibraryAccessors getMaterial() {
            return laccForAndroidxMaterialLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.media</b>
         */
        public AndroidxMediaLibraryAccessors getMedia() {
            return laccForAndroidxMediaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.media3</b>
         */
        public AndroidxMedia3LibraryAccessors getMedia3() {
            return laccForAndroidxMedia3LibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.navigation</b>
         */
        public AndroidxNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxNavigationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.paging</b>
         */
        public AndroidxPagingLibraryAccessors getPaging() {
            return laccForAndroidxPagingLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.palette</b>
         */
        public AndroidxPaletteLibraryAccessors getPalette() {
            return laccForAndroidxPaletteLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.room</b>
         */
        public AndroidxRoomLibraryAccessors getRoom() {
            return laccForAndroidxRoomLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.security</b>
         */
        public AndroidxSecurityLibraryAccessors getSecurity() {
            return laccForAndroidxSecurityLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.test</b>
         */
        public AndroidxTestLibraryAccessors getTest() {
            return laccForAndroidxTestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui</b>
         */
        public AndroidxUiLibraryAccessors getUi() {
            return laccForAndroidxUiLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.work</b>
         */
        public AndroidxWorkLibraryAccessors getWork() {
            return laccForAndroidxWorkLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.activity:activity-compose</b> coordinates and
         * with version reference <b>activityCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.activity.compose");
        }

    }

    public static class AndroidxAppLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxAppLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>app</b> with <b>androidx.car.app:app</b> coordinates and
         * with version reference <b>app</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.app");
        }

        /**
         * Dependency provider for <b>projected</b> with <b>androidx.car.app:app-projected</b> coordinates and
         * with version reference <b>app</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProjected() {
            return create("androidx.app.projected");
        }

    }

    public static class AndroidxBenchmarkLibraryAccessors extends SubDependencyFactory {
        private final AndroidxBenchmarkMacroLibraryAccessors laccForAndroidxBenchmarkMacroLibraryAccessors = new AndroidxBenchmarkMacroLibraryAccessors(owner);

        public AndroidxBenchmarkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.benchmark.macro</b>
         */
        public AndroidxBenchmarkMacroLibraryAccessors getMacro() {
            return laccForAndroidxBenchmarkMacroLibraryAccessors;
        }

    }

    public static class AndroidxBenchmarkMacroLibraryAccessors extends SubDependencyFactory {

        public AndroidxBenchmarkMacroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit4</b> with <b>androidx.benchmark:benchmark-macro-junit4</b> coordinates and
         * with version reference <b>benchmarkMacroJunit4</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit4() {
            return create("androidx.benchmark.macro.junit4");
        }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bom</b> with <b>androidx.compose:compose-bom</b> coordinates and
         * with version reference <b>composeBom</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBom() {
            return create("androidx.compose.bom");
        }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.compose.material3:material3</b> coordinates and
         * with version reference <b>material3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("androidx.compose.material3");
        }

    }

    public static class AndroidxConstraintlayoutLibraryAccessors extends SubDependencyFactory {

        public AndroidxConstraintlayoutLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.constraintlayout:constraintlayout-compose</b> coordinates and
         * with version reference <b>constraintlayoutCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.constraintlayout.compose");
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.core:core-ktx</b> coordinates and
         * with version reference <b>coreKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.core.ktx");
        }

        /**
         * Dependency provider for <b>splashscreen</b> with <b>androidx.core:core-splashscreen</b> coordinates and
         * with version reference <b>coreSplashscreen</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSplashscreen() {
            return create("androidx.core.splashscreen");
        }

    }

    public static class AndroidxDatastoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxDatastoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>preferences</b> with <b>androidx.datastore:datastore-preferences</b> coordinates and
         * with version reference <b>datastore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPreferences() {
            return create("androidx.datastore.preferences");
        }

    }

    public static class AndroidxEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.test.espresso:espresso-core</b> coordinates and
         * with version reference <b>espressoCore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("androidx.espresso.core");
        }

    }

    public static class AndroidxGlanceLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxGlanceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>glance</b> with <b>androidx.glance:glance</b> coordinates and
         * with version reference <b>glance</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.glance");
        }

        /**
         * Dependency provider for <b>appwidget</b> with <b>androidx.glance:glance-appwidget</b> coordinates and
         * with version reference <b>glance</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppwidget() {
            return create("androidx.glance.appwidget");
        }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.glance:glance-material3</b> coordinates and
         * with version reference <b>glance</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("androidx.glance.material3");
        }

    }

    public static class AndroidxGraphicsLibraryAccessors extends SubDependencyFactory {

        public AndroidxGraphicsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>shapes</b> with <b>androidx.graphics:graphics-shapes</b> coordinates and
         * with version reference <b>graphicsShapes</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getShapes() {
            return create("androidx.graphics.shapes");
        }

    }

    public static class AndroidxHiltLibraryAccessors extends SubDependencyFactory {
        private final AndroidxHiltLifecycleLibraryAccessors laccForAndroidxHiltLifecycleLibraryAccessors = new AndroidxHiltLifecycleLibraryAccessors(owner);
        private final AndroidxHiltNavigationLibraryAccessors laccForAndroidxHiltNavigationLibraryAccessors = new AndroidxHiltNavigationLibraryAccessors(owner);

        public AndroidxHiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>androidx.hilt:hilt-compiler</b> coordinates and
         * with version reference <b>hiltNavigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("androidx.hilt.compiler");
        }

        /**
         * Dependency provider for <b>work</b> with <b>androidx.hilt:hilt-work</b> coordinates and
         * with version reference <b>hiltNavigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWork() {
            return create("androidx.hilt.work");
        }

        /**
         * Group of libraries at <b>androidx.hilt.lifecycle</b>
         */
        public AndroidxHiltLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxHiltLifecycleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.hilt.navigation</b>
         */
        public AndroidxHiltNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxHiltNavigationLibraryAccessors;
        }

    }

    public static class AndroidxHiltLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxHiltLifecycleViewmodelLibraryAccessors laccForAndroidxHiltLifecycleViewmodelLibraryAccessors = new AndroidxHiltLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxHiltLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.hilt.lifecycle.viewmodel</b>
         */
        public AndroidxHiltLifecycleViewmodelLibraryAccessors getViewmodel() {
            return laccForAndroidxHiltLifecycleViewmodelLibraryAccessors;
        }

    }

    public static class AndroidxHiltLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxHiltLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.hilt:hilt-lifecycle-viewmodel-compose</b> coordinates and
         * with version reference <b>hiltNavigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.hilt.lifecycle.viewmodel.compose");
        }

    }

    public static class AndroidxHiltNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxHiltNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.hilt:hilt-navigation-compose</b> coordinates and
         * with version reference <b>hiltNavigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.hilt.navigation.compose");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.lifecycle.runtime</b>
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxLifecycleRuntimeLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.lifecycle:lifecycle-runtime-compose</b> coordinates and
         * with version reference <b>lifecycleRuntimeKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.lifecycle.runtime.compose");
        }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.lifecycle:lifecycle-runtime-ktx</b> coordinates and
         * with version reference <b>lifecycleRuntimeKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.lifecycle.runtime.ktx");
        }

    }

    public static class AndroidxMaterialLibraryAccessors extends SubDependencyFactory {
        private final AndroidxMaterialIconsLibraryAccessors laccForAndroidxMaterialIconsLibraryAccessors = new AndroidxMaterialIconsLibraryAccessors(owner);

        public AndroidxMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.material.icons</b>
         */
        public AndroidxMaterialIconsLibraryAccessors getIcons() {
            return laccForAndroidxMaterialIconsLibraryAccessors;
        }

    }

    public static class AndroidxMaterialIconsLibraryAccessors extends SubDependencyFactory {

        public AndroidxMaterialIconsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.compose.material:material-icons-core</b> coordinates and
         * with version reference <b>composeMaterialIcons</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("androidx.material.icons.core");
        }

        /**
         * Dependency provider for <b>extended</b> with <b>androidx.compose.material:material-icons-extended</b> coordinates and
         * with version reference <b>composeMaterialIcons</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getExtended() {
            return create("androidx.material.icons.extended");
        }

    }

    public static class AndroidxMediaLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxMediaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>media</b> with <b>androidx.media:media</b> coordinates and
         * with version reference <b>media</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.media");
        }

        /**
         * Dependency provider for <b>router</b> with <b>androidx.mediarouter:mediarouter</b> coordinates and
         * with version reference <b>mediaRouter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRouter() {
            return create("androidx.media.router");
        }

    }

    public static class AndroidxMedia3LibraryAccessors extends SubDependencyFactory {
        private final AndroidxMedia3ExoplayerLibraryAccessors laccForAndroidxMedia3ExoplayerLibraryAccessors = new AndroidxMedia3ExoplayerLibraryAccessors(owner);

        public AndroidxMedia3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>session</b> with <b>androidx.media3:media3-session</b> coordinates and
         * with version reference <b>media3Session</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSession() {
            return create("androidx.media3.session");
        }

        /**
         * Dependency provider for <b>transformer</b> with <b>androidx.media3:media3-transformer</b> coordinates and
         * with version reference <b>media3Transformer</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTransformer() {
            return create("androidx.media3.transformer");
        }

        /**
         * Dependency provider for <b>ui</b> with <b>androidx.media3:media3-ui</b> coordinates and
         * with version reference <b>media3Session</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUi() {
            return create("androidx.media3.ui");
        }

        /**
         * Group of libraries at <b>androidx.media3.exoplayer</b>
         */
        public AndroidxMedia3ExoplayerLibraryAccessors getExoplayer() {
            return laccForAndroidxMedia3ExoplayerLibraryAccessors;
        }

    }

    public static class AndroidxMedia3ExoplayerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxMedia3ExoplayerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>exoplayer</b> with <b>androidx.media3:media3-exoplayer</b> coordinates and
         * with version reference <b>media3Session</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.media3.exoplayer");
        }

        /**
         * Dependency provider for <b>ffmpeg</b> with <b>org.jellyfin.media3:media3-ffmpeg-decoder</b> coordinates and
         * with version <b>1.9.0+1</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFfmpeg() {
            return create("androidx.media3.exoplayer.ffmpeg");
        }

        /**
         * Dependency provider for <b>hls</b> with <b>androidx.media3:media3-exoplayer-hls</b> coordinates and
         * with version reference <b>media3Session</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHls() {
            return create("androidx.media3.exoplayer.hls");
        }

        /**
         * Dependency provider for <b>midi</b> with <b>androidx.media3:media3-exoplayer-midi</b> coordinates and
         * with version reference <b>media3Session</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMidi() {
            return create("androidx.media3.exoplayer.midi");
        }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationRuntimeLibraryAccessors laccForAndroidxNavigationRuntimeLibraryAccessors = new AndroidxNavigationRuntimeLibraryAccessors(owner);

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.navigation:navigation-compose</b> coordinates and
         * with version reference <b>navigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.navigation.compose");
        }

        /**
         * Group of libraries at <b>androidx.navigation.runtime</b>
         */
        public AndroidxNavigationRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxNavigationRuntimeLibraryAccessors;
        }

    }

    public static class AndroidxNavigationRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-runtime-ktx</b> coordinates and
         * with version reference <b>navigationRuntimeKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.navigation.runtime.ktx");
        }

    }

    public static class AndroidxPagingLibraryAccessors extends SubDependencyFactory {

        public AndroidxPagingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>common</b> with <b>androidx.paging:paging-common</b> coordinates and
         * with version <b>3.5.0</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommon() {
            return create("androidx.paging.common");
        }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.paging:paging-compose</b> coordinates and
         * with version reference <b>paging</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.paging.compose");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.paging:paging-runtime</b> coordinates and
         * with version reference <b>paging</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.paging.runtime");
        }

    }

    public static class AndroidxPaletteLibraryAccessors extends SubDependencyFactory {

        public AndroidxPaletteLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.palette:palette-ktx</b> coordinates and
         * with version reference <b>paletteKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.palette.ktx");
        }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory {

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>androidx.room:room-compiler</b> coordinates and
         * with version reference <b>roomCompiler</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("androidx.room.compiler");
        }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.room:room-ktx</b> coordinates and
         * with version reference <b>roomKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.room.ktx");
        }

        /**
         * Dependency provider for <b>paging</b> with <b>androidx.room:room-paging</b> coordinates and
         * with version reference <b>roomRuntime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPaging() {
            return create("androidx.room.paging");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.room:room-runtime</b> coordinates and
         * with version reference <b>roomRuntime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.room.runtime");
        }

        /**
         * Dependency provider for <b>testing</b> with <b>androidx.room:room-testing</b> coordinates and
         * with version reference <b>roomRuntime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("androidx.room.testing");
        }

    }

    public static class AndroidxSecurityLibraryAccessors extends SubDependencyFactory {

        public AndroidxSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>crypto</b> with <b>androidx.security:security-crypto</b> coordinates and
         * with version reference <b>securityCrypto</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCrypto() {
            return create("androidx.security.crypto");
        }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.test:core</b> coordinates and
         * with version reference <b>androidxTestCore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("androidx.test.core");
        }

    }

    public static class AndroidxUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxUiTestLibraryAccessors laccForAndroidxUiTestLibraryAccessors = new AndroidxUiTestLibraryAccessors(owner);
        private final AndroidxUiTextLibraryAccessors laccForAndroidxUiTextLibraryAccessors = new AndroidxUiTextLibraryAccessors(owner);
        private final AndroidxUiToolingLibraryAccessors laccForAndroidxUiToolingLibraryAccessors = new AndroidxUiToolingLibraryAccessors(owner);

        public AndroidxUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>androidx.compose.ui:ui</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui");
        }

        /**
         * Dependency provider for <b>graphics</b> with <b>androidx.compose.ui:ui-graphics</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGraphics() {
            return create("androidx.ui.graphics");
        }

        /**
         * Group of libraries at <b>androidx.ui.test</b>
         */
        public AndroidxUiTestLibraryAccessors getTest() {
            return laccForAndroidxUiTestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui.text</b>
         */
        public AndroidxUiTextLibraryAccessors getText() {
            return laccForAndroidxUiTextLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui.tooling</b>
         */
        public AndroidxUiToolingLibraryAccessors getTooling() {
            return laccForAndroidxUiToolingLibraryAccessors;
        }

    }

    public static class AndroidxUiTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxUiTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit4</b> with <b>androidx.compose.ui:ui-test-junit4</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit4() {
            return create("androidx.ui.test.junit4");
        }

        /**
         * Dependency provider for <b>manifest</b> with <b>androidx.compose.ui:ui-test-manifest</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getManifest() {
            return create("androidx.ui.test.manifest");
        }

    }

    public static class AndroidxUiTextLibraryAccessors extends SubDependencyFactory {
        private final AndroidxUiTextGoogleLibraryAccessors laccForAndroidxUiTextGoogleLibraryAccessors = new AndroidxUiTextGoogleLibraryAccessors(owner);

        public AndroidxUiTextLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.ui.text.google</b>
         */
        public AndroidxUiTextGoogleLibraryAccessors getGoogle() {
            return laccForAndroidxUiTextGoogleLibraryAccessors;
        }

    }

    public static class AndroidxUiTextGoogleLibraryAccessors extends SubDependencyFactory {

        public AndroidxUiTextGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>fonts</b> with <b>androidx.compose.ui:ui-text-google-fonts</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFonts() {
            return create("androidx.ui.text.google.fonts");
        }

    }

    public static class AndroidxUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tooling</b> with <b>androidx.compose.ui:ui-tooling</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui.tooling");
        }

        /**
         * Dependency provider for <b>preview</b> with <b>androidx.compose.ui:ui-tooling-preview</b> coordinates and
         * with version reference <b>composeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPreview() {
            return create("androidx.ui.tooling.preview");
        }

    }

    public static class AndroidxWorkLibraryAccessors extends SubDependencyFactory {
        private final AndroidxWorkRuntimeLibraryAccessors laccForAndroidxWorkRuntimeLibraryAccessors = new AndroidxWorkRuntimeLibraryAccessors(owner);

        public AndroidxWorkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.work.runtime</b>
         */
        public AndroidxWorkRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxWorkRuntimeLibraryAccessors;
        }

    }

    public static class AndroidxWorkRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxWorkRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.work:work-runtime-ktx</b> coordinates and
         * with version reference <b>workRuntimeKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.work.runtime.ktx");
        }

    }

    public static class ApacheLibraryAccessors extends SubDependencyFactory {

        public ApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>httpclient</b> with <b>org.apache.httpcomponents:httpclient</b> coordinates and
         * with version reference <b>httpclient</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHttpclient() {
            return create("apache.httpclient");
        }

    }

    public static class BouncycastleLibraryAccessors extends SubDependencyFactory {

        public BouncycastleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bcpkix</b> with <b>org.bouncycastle:bcpkix-jdk18on</b> coordinates and
         * with version reference <b>bouncycastle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBcpkix() {
            return create("bouncycastle.bcpkix");
        }

        /**
         * Dependency provider for <b>bcprov</b> with <b>org.bouncycastle:bcprov-jdk18on</b> coordinates and
         * with version reference <b>bouncycastle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBcprov() {
            return create("bouncycastle.bcprov");
        }

    }

    public static class CheckerLibraryAccessors extends SubDependencyFactory {

        public CheckerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>qual</b> with <b>org.checkerframework:checker-qual</b> coordinates and
         * with version reference <b>checkerframework</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getQual() {
            return create("checker.qual");
        }

    }

    public static class CoilLibraryAccessors extends SubDependencyFactory {

        public CoilLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>io.coil-kt:coil-compose</b> coordinates and
         * with version reference <b>coilCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("coil.compose");
        }

    }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>lang3</b> with <b>org.apache.commons:commons-lang3</b> coordinates and
         * with version reference <b>commons.lang3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLang3() {
            return create("commons.lang3");
        }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {
        private final ComposeMaterial3LibraryAccessors laccForComposeMaterial3LibraryAccessors = new ComposeMaterial3LibraryAccessors(owner);
        private final ComposeUiLibraryAccessors laccForComposeUiLibraryAccessors = new ComposeUiLibraryAccessors(owner);
        private final ComposeWebLibraryAccessors laccForComposeWebLibraryAccessors = new ComposeWebLibraryAccessors(owner);

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>animation</b> with <b>org.jetbrains.compose.animation:animation</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnimation() {
            return create("compose.animation");
        }

        /**
         * Dependency provider for <b>dnd</b> with <b>com.mohamedrejeb.dnd:compose-dnd</b> coordinates and
         * with version reference <b>composeDnd</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDnd() {
            return create("compose.dnd");
        }

        /**
         * Dependency provider for <b>foundation</b> with <b>org.jetbrains.compose.foundation:foundation</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFoundation() {
            return create("compose.foundation");
        }

        /**
         * Dependency provider for <b>multiplatform</b> with <b>org.jetbrains.compose:compose-multiplatform</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMultiplatform() {
            return create("compose.multiplatform");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>org.jetbrains.compose.runtime:runtime</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("compose.runtime");
        }

        /**
         * Group of libraries at <b>compose.material3</b>
         */
        public ComposeMaterial3LibraryAccessors getMaterial3() {
            return laccForComposeMaterial3LibraryAccessors;
        }

        /**
         * Group of libraries at <b>compose.ui</b>
         */
        public ComposeUiLibraryAccessors getUi() {
            return laccForComposeUiLibraryAccessors;
        }

        /**
         * Group of libraries at <b>compose.web</b>
         */
        public ComposeWebLibraryAccessors getWeb() {
            return laccForComposeWebLibraryAccessors;
        }

    }

    public static class ComposeMaterial3LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final ComposeMaterial3IconsLibraryAccessors laccForComposeMaterial3IconsLibraryAccessors = new ComposeMaterial3IconsLibraryAccessors(owner);

        public ComposeMaterial3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>material3</b> with <b>org.jetbrains.compose.material3:material3</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("compose.material3");
        }

        /**
         * Group of libraries at <b>compose.material3.icons</b>
         */
        public ComposeMaterial3IconsLibraryAccessors getIcons() {
            return laccForComposeMaterial3IconsLibraryAccessors;
        }

    }

    public static class ComposeMaterial3IconsLibraryAccessors extends SubDependencyFactory {

        public ComposeMaterial3IconsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.compose.material3:material3-icons-core</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("compose.material3.icons.core");
        }

        /**
         * Dependency provider for <b>extended</b> with <b>org.jetbrains.compose.material3:material3-icons-extended</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getExtended() {
            return create("compose.material3.icons.extended");
        }

        /**
         * Dependency provider for <b>filled</b> with <b>org.jetbrains.compose.material3:material3-icons-filled</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFilled() {
            return create("compose.material3.icons.filled");
        }

        /**
         * Dependency provider for <b>outlined</b> with <b>org.jetbrains.compose.material3:material3-icons-outlined</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOutlined() {
            return create("compose.material3.icons.outlined");
        }

        /**
         * Dependency provider for <b>sharp</b> with <b>org.jetbrains.compose.material3:material3-icons-sharp</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSharp() {
            return create("compose.material3.icons.sharp");
        }

        /**
         * Dependency provider for <b>twotone</b> with <b>org.jetbrains.compose.material3:material3-icons-twotone</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTwotone() {
            return create("compose.material3.icons.twotone");
        }

    }

    public static class ComposeUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final ComposeUiToolingLibraryAccessors laccForComposeUiToolingLibraryAccessors = new ComposeUiToolingLibraryAccessors(owner);

        public ComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>org.jetbrains.compose.ui:ui</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("compose.ui");
        }

        /**
         * Dependency provider for <b>graphics</b> with <b>org.jetbrains.compose.ui:ui-graphics</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGraphics() {
            return create("compose.ui.graphics");
        }

        /**
         * Dependency provider for <b>text</b> with <b>org.jetbrains.compose.ui:ui-text</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getText() {
            return create("compose.ui.text");
        }

        /**
         * Group of libraries at <b>compose.ui.tooling</b>
         */
        public ComposeUiToolingLibraryAccessors getTooling() {
            return laccForComposeUiToolingLibraryAccessors;
        }

    }

    public static class ComposeUiToolingLibraryAccessors extends SubDependencyFactory {

        public ComposeUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>preview</b> with <b>org.jetbrains.compose.ui:ui-tooling-preview</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPreview() {
            return create("compose.ui.tooling.preview");
        }

    }

    public static class ComposeWebLibraryAccessors extends SubDependencyFactory {

        public ComposeWebLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>canvas</b> with <b>org.jetbrains.compose.web:compose-web-canvas</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCanvas() {
            return create("compose.web.canvas");
        }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.compose.web:compose-web-core</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("compose.web.core");
        }

        /**
         * Dependency provider for <b>dom</b> with <b>org.jetbrains.compose.web:compose-web-dom</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDom() {
            return create("compose.web.dom");
        }

        /**
         * Dependency provider for <b>svg</b> with <b>org.jetbrains.compose.web:compose-web-svg</b> coordinates and
         * with version reference <b>composeMultiplatform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSvg() {
            return create("compose.web.svg");
        }

    }

    public static class ConverterLibraryAccessors extends SubDependencyFactory {

        public ConverterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gson</b> with <b>com.squareup.retrofit2:converter-gson</b> coordinates and
         * with version reference <b>retrofit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("converter.gson");
        }

    }

    public static class CredentialsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final CredentialsPlayLibraryAccessors laccForCredentialsPlayLibraryAccessors = new CredentialsPlayLibraryAccessors(owner);

        public CredentialsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>credentials</b> with <b>androidx.credentials:credentials</b> coordinates and
         * with version reference <b>credentials</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("credentials");
        }

        /**
         * Group of libraries at <b>credentials.play</b>
         */
        public CredentialsPlayLibraryAccessors getPlay() {
            return laccForCredentialsPlayLibraryAccessors;
        }

    }

    public static class CredentialsPlayLibraryAccessors extends SubDependencyFactory {
        private final CredentialsPlayServicesLibraryAccessors laccForCredentialsPlayServicesLibraryAccessors = new CredentialsPlayServicesLibraryAccessors(owner);

        public CredentialsPlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>credentials.play.services</b>
         */
        public CredentialsPlayServicesLibraryAccessors getServices() {
            return laccForCredentialsPlayServicesLibraryAccessors;
        }

    }

    public static class CredentialsPlayServicesLibraryAccessors extends SubDependencyFactory {

        public CredentialsPlayServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>auth</b> with <b>androidx.credentials:credentials-play-services-auth</b> coordinates and
         * with version reference <b>credentials</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAuth() {
            return create("credentials.play.services.auth");
        }

    }

    public static class DesugarLibraryAccessors extends SubDependencyFactory {
        private final DesugarJdkLibraryAccessors laccForDesugarJdkLibraryAccessors = new DesugarJdkLibraryAccessors(owner);

        public DesugarLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>desugar.jdk</b>
         */
        public DesugarJdkLibraryAccessors getJdk() {
            return laccForDesugarJdkLibraryAccessors;
        }

    }

    public static class DesugarJdkLibraryAccessors extends SubDependencyFactory {

        public DesugarJdkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>libs</b> with <b>com.android.tools:desugar_jdk_libs</b> coordinates and
         * with version reference <b>desugarJdkLibs</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLibs() {
            return create("desugar.jdk.libs");
        }

    }

    public static class DuktapeLibraryAccessors extends SubDependencyFactory {

        public DuktapeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>com.squareup.duktape:duktape-android</b> coordinates and
         * with version reference <b>duktapeAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("duktape.android");
        }

    }

    public static class FuelLibraryAccessors extends SubDependencyFactory {

        public FuelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>com.github.kittinunf.fuel:fuel-android</b> coordinates and
         * with version reference <b>fuel</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("fuel.android");
        }

        /**
         * Dependency provider for <b>json</b> with <b>com.github.kittinunf.fuel:fuel-json</b> coordinates and
         * with version reference <b>fuel</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("fuel.json");
        }

    }

    public static class GoogleLibraryAccessors extends SubDependencyFactory {
        private final GooglePlayLibraryAccessors laccForGooglePlayLibraryAccessors = new GooglePlayLibraryAccessors(owner);

        public GoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>genai</b> with <b>com.google.genai:google-genai</b> coordinates and
         * with version reference <b>googleGenai</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGenai() {
            return create("google.genai");
        }

        /**
         * Group of libraries at <b>google.play</b>
         */
        public GooglePlayLibraryAccessors getPlay() {
            return laccForGooglePlayLibraryAccessors;
        }

    }

    public static class GooglePlayLibraryAccessors extends SubDependencyFactory {
        private final GooglePlayServicesLibraryAccessors laccForGooglePlayServicesLibraryAccessors = new GooglePlayServicesLibraryAccessors(owner);

        public GooglePlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>google.play.services</b>
         */
        public GooglePlayServicesLibraryAccessors getServices() {
            return laccForGooglePlayServicesLibraryAccessors;
        }

    }

    public static class GooglePlayServicesLibraryAccessors extends SubDependencyFactory {
        private final GooglePlayServicesCastLibraryAccessors laccForGooglePlayServicesCastLibraryAccessors = new GooglePlayServicesCastLibraryAccessors(owner);

        public GooglePlayServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>google.play.services.cast</b>
         */
        public GooglePlayServicesCastLibraryAccessors getCast() {
            return laccForGooglePlayServicesCastLibraryAccessors;
        }

    }

    public static class GooglePlayServicesCastLibraryAccessors extends SubDependencyFactory {

        public GooglePlayServicesCastLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>framework</b> with <b>com.google.android.gms:play-services-cast-framework</b> coordinates and
         * with version reference <b>googlePlayServicesCast</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFramework() {
            return create("google.play.services.cast.framework");
        }

    }

    public static class HiltLibraryAccessors extends SubDependencyFactory {
        private final HiltAndroidLibraryAccessors laccForHiltAndroidLibraryAccessors = new HiltAndroidLibraryAccessors(owner);

        public HiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>hilt.android</b>
         */
        public HiltAndroidLibraryAccessors getAndroid() {
            return laccForHiltAndroidLibraryAccessors;
        }

    }

    public static class HiltAndroidLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HiltAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>com.google.dagger:hilt-android</b> coordinates and
         * with version reference <b>hiltAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("hilt.android");
        }

        /**
         * Dependency provider for <b>compiler</b> with <b>com.google.dagger:hilt-android-compiler</b> coordinates and
         * with version reference <b>hiltAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("hilt.android.compiler");
        }

    }

    public static class HorologistLibraryAccessors extends SubDependencyFactory {
        private final HorologistAudioLibraryAccessors laccForHorologistAudioLibraryAccessors = new HorologistAudioLibraryAccessors(owner);
        private final HorologistComposeLibraryAccessors laccForHorologistComposeLibraryAccessors = new HorologistComposeLibraryAccessors(owner);
        private final HorologistMediaLibraryAccessors laccForHorologistMediaLibraryAccessors = new HorologistMediaLibraryAccessors(owner);

        public HorologistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>composables</b> with <b>com.google.android.horologist:horologist-composables</b> coordinates and
         * with version reference <b>horologist</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getComposables() {
            return create("horologist.composables");
        }

        /**
         * Group of libraries at <b>horologist.audio</b>
         */
        public HorologistAudioLibraryAccessors getAudio() {
            return laccForHorologistAudioLibraryAccessors;
        }

        /**
         * Group of libraries at <b>horologist.compose</b>
         */
        public HorologistComposeLibraryAccessors getCompose() {
            return laccForHorologistComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>horologist.media</b>
         */
        public HorologistMediaLibraryAccessors getMedia() {
            return laccForHorologistMediaLibraryAccessors;
        }

    }

    public static class HorologistAudioLibraryAccessors extends SubDependencyFactory {

        public HorologistAudioLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>com.google.android.horologist:horologist-audio-ui</b> coordinates and
         * with version reference <b>horologist</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUi() {
            return create("horologist.audio.ui");
        }

    }

    public static class HorologistComposeLibraryAccessors extends SubDependencyFactory {

        public HorologistComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>layout</b> with <b>com.google.android.horologist:horologist-compose-layout</b> coordinates and
         * with version reference <b>horologist</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLayout() {
            return create("horologist.compose.layout");
        }

    }

    public static class HorologistMediaLibraryAccessors extends SubDependencyFactory {

        public HorologistMediaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>com.google.android.horologist:horologist-media-ui</b> coordinates and
         * with version reference <b>horologist</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUi() {
            return create("horologist.media.ui");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final JunitJupiterLibraryAccessors laccForJunitJupiterLibraryAccessors = new JunitJupiterLibraryAccessors(owner);
        private final JunitVintageLibraryAccessors laccForJunitVintageLibraryAccessors = new JunitVintageLibraryAccessors(owner);

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("junit");
        }

        /**
         * Group of libraries at <b>junit.jupiter</b>
         */
        public JunitJupiterLibraryAccessors getJupiter() {
            return laccForJunitJupiterLibraryAccessors;
        }

        /**
         * Group of libraries at <b>junit.vintage</b>
         */
        public JunitVintageLibraryAccessors getVintage() {
            return laccForJunitVintageLibraryAccessors;
        }

    }

    public static class JunitJupiterLibraryAccessors extends SubDependencyFactory {

        public JunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.junit.jupiter:junit-jupiter-api</b> coordinates and
         * with version reference <b>junitJupiter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("junit.jupiter.api");
        }

        /**
         * Dependency provider for <b>engine</b> with <b>org.junit.jupiter:junit-jupiter-engine</b> coordinates and
         * with version reference <b>junitJupiter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEngine() {
            return create("junit.jupiter.engine");
        }

        /**
         * Dependency provider for <b>params</b> with <b>org.junit.jupiter:junit-jupiter-params</b> coordinates and
         * with version reference <b>junit5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getParams() {
            return create("junit.jupiter.params");
        }

    }

    public static class JunitVintageLibraryAccessors extends SubDependencyFactory {

        public JunitVintageLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>engine</b> with <b>org.junit.vintage:junit-vintage-engine</b> coordinates and
         * with version reference <b>junitJupiter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEngine() {
            return create("junit.vintage.engine");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinTestLibraryAccessors laccForKotlinTestLibraryAccessors = new KotlinTestLibraryAccessors(owner);
        private final KotlinWasmLibraryAccessors laccForKotlinWasmLibraryAccessors = new KotlinWasmLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>logging</b> with <b>io.github.microutils:kotlin-logging-jvm</b> coordinates and
         * with version <b>3.0.0</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLogging() {
            return create("kotlin.logging");
        }

        /**
         * Group of libraries at <b>kotlin.test</b>
         */
        public KotlinTestLibraryAccessors getTest() {
            return laccForKotlinTestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlin.wasm</b>
         */
        public KotlinWasmLibraryAccessors getWasm() {
            return laccForKotlinWasmLibraryAccessors;
        }

    }

    public static class KotlinTestLibraryAccessors extends SubDependencyFactory {

        public KotlinTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>org.jetbrains.kotlin:kotlin-test-junit</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("kotlin.test.junit");
        }

    }

    public static class KotlinWasmLibraryAccessors extends SubDependencyFactory {

        public KotlinWasmLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>dom</b> with <b>org.jetbrains.kotlin-wasm:kotlin-wasm-dom</b> coordinates and
         * with version <b>2.4.0</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDom() {
            return create("kotlin.wasm.dom");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCollectionsLibraryAccessors laccForKotlinxCollectionsLibraryAccessors = new KotlinxCollectionsLibraryAccessors(owner);
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>datetime</b> with <b>org.jetbrains.kotlinx:kotlinx-datetime</b> coordinates and
         * with version reference <b>kotlinxDatetime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDatetime() {
            return create("kotlinx.datetime");
        }

        /**
         * Group of libraries at <b>kotlinx.collections</b>
         */
        public KotlinxCollectionsLibraryAccessors getCollections() {
            return laccForKotlinxCollectionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlinx.coroutines</b>
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForKotlinxCoroutinesLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlinx.serialization</b>
         */
        public KotlinxSerializationLibraryAccessors getSerialization() {
            return laccForKotlinxSerializationLibraryAccessors;
        }

    }

    public static class KotlinxCollectionsLibraryAccessors extends SubDependencyFactory {

        public KotlinxCollectionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>immutable</b> with <b>org.jetbrains.kotlinx:kotlinx-collections-immutable</b> coordinates and
         * with version reference <b>kotlinxCollectionsImmutable</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getImmutable() {
            return create("kotlinx.collections.immutable");
        }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesCoreLibraryAccessors laccForKotlinxCoroutinesCoreLibraryAccessors = new KotlinxCoroutinesCoreLibraryAccessors(owner);
        private final KotlinxCoroutinesPlayLibraryAccessors laccForKotlinxCoroutinesPlayLibraryAccessors = new KotlinxCoroutinesPlayLibraryAccessors(owner);

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-android</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("kotlinx.coroutines.android");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-test</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("kotlinx.coroutines.test");
        }

        /**
         * Group of libraries at <b>kotlinx.coroutines.core</b>
         */
        public KotlinxCoroutinesCoreLibraryAccessors getCore() {
            return laccForKotlinxCoroutinesCoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlinx.coroutines.play</b>
         */
        public KotlinxCoroutinesPlayLibraryAccessors getPlay() {
            return laccForKotlinxCoroutinesPlayLibraryAccessors;
        }

    }

    public static class KotlinxCoroutinesCoreLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public KotlinxCoroutinesCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("kotlinx.coroutines.core");
        }

        /**
         * Dependency provider for <b>js</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core-js</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJs() {
            return create("kotlinx.coroutines.core.js");
        }

    }

    public static class KotlinxCoroutinesPlayLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesPlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>services</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-play-services</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getServices() {
            return create("kotlinx.coroutines.play.services");
        }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>org.jetbrains.kotlinx:kotlinx-serialization-json</b> coordinates and
         * with version reference <b>kotlinxSerializationJson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("kotlinx.serialization.json");
        }

    }

    public static class KtorLibraryAccessors extends SubDependencyFactory {
        private final KtorClientLibraryAccessors laccForKtorClientLibraryAccessors = new KtorClientLibraryAccessors(owner);
        private final KtorSerializationLibraryAccessors laccForKtorSerializationLibraryAccessors = new KtorSerializationLibraryAccessors(owner);
        private final KtorServerLibraryAccessors laccForKtorServerLibraryAccessors = new KtorServerLibraryAccessors(owner);

        public KtorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>ktor.client</b>
         */
        public KtorClientLibraryAccessors getClient() {
            return laccForKtorClientLibraryAccessors;
        }

        /**
         * Group of libraries at <b>ktor.serialization</b>
         */
        public KtorSerializationLibraryAccessors getSerialization() {
            return laccForKtorSerializationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>ktor.server</b>
         */
        public KtorServerLibraryAccessors getServer() {
            return laccForKtorServerLibraryAccessors;
        }

    }

    public static class KtorClientLibraryAccessors extends SubDependencyFactory {
        private final KtorClientContentLibraryAccessors laccForKtorClientContentLibraryAccessors = new KtorClientContentLibraryAccessors(owner);

        public KtorClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-client-core</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("ktor.client.core");
        }

        /**
         * Dependency provider for <b>encoding</b> with <b>io.ktor:ktor-client-encoding</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEncoding() {
            return create("ktor.client.encoding");
        }

        /**
         * Dependency provider for <b>js</b> with <b>io.ktor:ktor-client-js</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJs() {
            return create("ktor.client.js");
        }

        /**
         * Dependency provider for <b>logging</b> with <b>io.ktor:ktor-client-logging</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLogging() {
            return create("ktor.client.logging");
        }

        /**
         * Dependency provider for <b>okhttp</b> with <b>io.ktor:ktor-client-okhttp</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() {
            return create("ktor.client.okhttp");
        }

        /**
         * Group of libraries at <b>ktor.client.content</b>
         */
        public KtorClientContentLibraryAccessors getContent() {
            return laccForKtorClientContentLibraryAccessors;
        }

    }

    public static class KtorClientContentLibraryAccessors extends SubDependencyFactory {

        public KtorClientContentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>negotiation</b> with <b>io.ktor:ktor-client-content-negotiation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNegotiation() {
            return create("ktor.client.content.negotiation");
        }

    }

    public static class KtorSerializationLibraryAccessors extends SubDependencyFactory {

        public KtorSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>io.ktor:ktor-serialization-kotlinx-json</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("ktor.serialization.json");
        }

    }

    public static class KtorServerLibraryAccessors extends SubDependencyFactory {

        public KtorServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-server-cio-jvm</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCio() {
            return create("ktor.server.cio");
        }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-server-core-jvm</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("ktor.server.core");
        }

        /**
         * Dependency provider for <b>netty</b> with <b>io.ktor:ktor-server-netty-jvm</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNetty() {
            return create("ktor.server.netty");
        }

    }

    public static class KuromojiLibraryAccessors extends SubDependencyFactory {

        public KuromojiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ipadic</b> with <b>com.atilika.kuromoji:kuromoji-ipadic</b> coordinates and
         * with version reference <b>kuromoji</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIpadic() {
            return create("kuromoji.ipadic");
        }

    }

    public static class LoggingLibraryAccessors extends SubDependencyFactory {

        public LoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>interceptor</b> with <b>com.squareup.okhttp3:logging-interceptor</b> coordinates and
         * with version reference <b>okhttp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getInterceptor() {
            return create("logging.interceptor");
        }

    }

    public static class NettyLibraryAccessors extends SubDependencyFactory {
        private final NettyCodecLibraryAccessors laccForNettyCodecLibraryAccessors = new NettyCodecLibraryAccessors(owner);

        public NettyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>common</b> with <b>io.netty:netty-common</b> coordinates and
         * with version reference <b>netty</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommon() {
            return create("netty.common");
        }

        /**
         * Dependency provider for <b>handler</b> with <b>io.netty:netty-handler</b> coordinates and
         * with version reference <b>netty</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHandler() {
            return create("netty.handler");
        }

        /**
         * Group of libraries at <b>netty.codec</b>
         */
        public NettyCodecLibraryAccessors getCodec() {
            return laccForNettyCodecLibraryAccessors;
        }

    }

    public static class NettyCodecLibraryAccessors extends SubDependencyFactory {

        public NettyCodecLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>http</b> with <b>io.netty:netty-codec-http</b> coordinates and
         * with version reference <b>netty</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHttp() {
            return create("netty.codec.http");
        }

        /**
         * Dependency provider for <b>http2</b> with <b>io.netty:netty-codec-http2</b> coordinates and
         * with version reference <b>netty</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHttp2() {
            return create("netty.codec.http2");
        }

    }

    public static class NewpipeLibraryAccessors extends SubDependencyFactory {

        public NewpipeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>extractor</b> with <b>com.github.TeamNewPipe:NewPipeExtractor</b> coordinates and
         * with version <b>v0.26.3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getExtractor() {
            return create("newpipe.extractor");
        }

    }

    public static class OkhttpLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OkhttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>okhttp</b> with <b>com.squareup.okhttp3:okhttp</b> coordinates and
         * with version reference <b>okhttp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("okhttp");
        }

        /**
         * Dependency provider for <b>dnsoverhttps</b> with <b>com.squareup.okhttp3:okhttp-dnsoverhttps</b> coordinates and
         * with version reference <b>okhttp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDnsoverhttps() {
            return create("okhttp.dnsoverhttps");
        }

    }

    public static class Pinyin4jLibraryAccessors extends SubDependencyFactory {

        public Pinyin4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>com.belerweb:pinyin4j</b> coordinates and
         * with version reference <b>pinyin4j</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("pinyin4j.core");
        }

    }

    public static class PlayLibraryAccessors extends SubDependencyFactory {
        private final PlayServicesLibraryAccessors laccForPlayServicesLibraryAccessors = new PlayServicesLibraryAccessors(owner);

        public PlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>play.services</b>
         */
        public PlayServicesLibraryAccessors getServices() {
            return laccForPlayServicesLibraryAccessors;
        }

    }

    public static class PlayServicesLibraryAccessors extends SubDependencyFactory {
        private final PlayServicesCastLibraryAccessors laccForPlayServicesCastLibraryAccessors = new PlayServicesCastLibraryAccessors(owner);

        public PlayServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>wearable</b> with <b>com.google.android.gms:play-services-wearable</b> coordinates and
         * with version reference <b>playServicesWearable</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWearable() {
            return create("play.services.wearable");
        }

        /**
         * Group of libraries at <b>play.services.cast</b>
         */
        public PlayServicesCastLibraryAccessors getCast() {
            return laccForPlayServicesCastLibraryAccessors;
        }

    }

    public static class PlayServicesCastLibraryAccessors extends SubDependencyFactory {

        public PlayServicesCastLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>framework</b> with <b>com.google.android.gms:play-services-cast-framework</b> coordinates and
         * with version reference <b>playServicesCastFramework</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFramework() {
            return create("play.services.cast.framework");
        }

    }

    public static class ProtobufLibraryAccessors extends SubDependencyFactory {

        public ProtobufLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>javalite</b> with <b>com.google.protobuf:protobuf-javalite</b> coordinates and
         * with version reference <b>protobufJavalite</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJavalite() {
            return create("protobuf.javalite");
        }

    }

    public static class PytorchLibraryAccessors extends SubDependencyFactory {
        private final PytorchAndroidLibraryAccessors laccForPytorchAndroidLibraryAccessors = new PytorchAndroidLibraryAccessors(owner);

        public PytorchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>pytorch.android</b>
         */
        public PytorchAndroidLibraryAccessors getAndroid() {
            return laccForPytorchAndroidLibraryAccessors;
        }

    }

    public static class PytorchAndroidLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public PytorchAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>org.pytorch:pytorch_android</b> coordinates and
         * with version reference <b>pytorch.android</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("pytorch.android");
        }

        /**
         * Dependency provider for <b>torchvision</b> with <b>org.pytorch:pytorch_android_torchvision</b> coordinates and
         * with version reference <b>pytorch.android.torchvision</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTorchvision() {
            return create("pytorch.android.torchvision");
        }

    }

    public static class SmoothLibraryAccessors extends SubDependencyFactory {
        private final SmoothCornerLibraryAccessors laccForSmoothCornerLibraryAccessors = new SmoothCornerLibraryAccessors(owner);

        public SmoothLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>smooth.corner</b>
         */
        public SmoothCornerLibraryAccessors getCorner() {
            return laccForSmoothCornerLibraryAccessors;
        }

    }

    public static class SmoothCornerLibraryAccessors extends SubDependencyFactory {
        private final SmoothCornerRectLibraryAccessors laccForSmoothCornerRectLibraryAccessors = new SmoothCornerRectLibraryAccessors(owner);

        public SmoothCornerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>smooth.corner.rect</b>
         */
        public SmoothCornerRectLibraryAccessors getRect() {
            return laccForSmoothCornerRectLibraryAccessors;
        }

    }

    public static class SmoothCornerRectLibraryAccessors extends SubDependencyFactory {
        private final SmoothCornerRectAndroidLibraryAccessors laccForSmoothCornerRectAndroidLibraryAccessors = new SmoothCornerRectAndroidLibraryAccessors(owner);

        public SmoothCornerRectLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>smooth.corner.rect.android</b>
         */
        public SmoothCornerRectAndroidLibraryAccessors getAndroid() {
            return laccForSmoothCornerRectAndroidLibraryAccessors;
        }

    }

    public static class SmoothCornerRectAndroidLibraryAccessors extends SubDependencyFactory {

        public SmoothCornerRectAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>com.github.racra:smooth-corner-rect-android-compose</b> coordinates and
         * with version reference <b>smoothCornerRectAndroidCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("smooth.corner.rect.android.compose");
        }

    }

    public static class SpleeterLibraryAccessors extends SubDependencyFactory {
        private final SpleeterAndroidLibraryAccessors laccForSpleeterAndroidLibraryAccessors = new SpleeterAndroidLibraryAccessors(owner);

        public SpleeterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>spleeter.android</b>
         */
        public SpleeterAndroidLibraryAccessors getAndroid() {
            return laccForSpleeterAndroidLibraryAccessors;
        }

    }

    public static class SpleeterAndroidLibraryAccessors extends SubDependencyFactory {

        public SpleeterAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ios</b> with <b>com.github.FaceOnLive:Spleeter-Android-iOS</b> coordinates and
         * with version reference <b>spleeterAndroidIos</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIos() {
            return create("spleeter.android.ios");
        }

    }

    public static class TensorflowLibraryAccessors extends SubDependencyFactory {
        private final TensorflowLiteLibraryAccessors laccForTensorflowLiteLibraryAccessors = new TensorflowLiteLibraryAccessors(owner);

        public TensorflowLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>tensorflow.lite</b>
         */
        public TensorflowLiteLibraryAccessors getLite() {
            return laccForTensorflowLiteLibraryAccessors;
        }

    }

    public static class TensorflowLiteLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final TensorflowLiteSelectLibraryAccessors laccForTensorflowLiteSelectLibraryAccessors = new TensorflowLiteSelectLibraryAccessors(owner);

        public TensorflowLiteLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>lite</b> with <b>org.tensorflow:tensorflow-lite</b> coordinates and
         * with version reference <b>tensorflowLite</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("tensorflow.lite");
        }

        /**
         * Dependency provider for <b>support</b> with <b>org.tensorflow:tensorflow-lite-support</b> coordinates and
         * with version reference <b>tensorflowLiteSupport</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSupport() {
            return create("tensorflow.lite.support");
        }

        /**
         * Group of libraries at <b>tensorflow.lite.select</b>
         */
        public TensorflowLiteSelectLibraryAccessors getSelect() {
            return laccForTensorflowLiteSelectLibraryAccessors;
        }

    }

    public static class TensorflowLiteSelectLibraryAccessors extends SubDependencyFactory {
        private final TensorflowLiteSelectTfLibraryAccessors laccForTensorflowLiteSelectTfLibraryAccessors = new TensorflowLiteSelectTfLibraryAccessors(owner);

        public TensorflowLiteSelectLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>tensorflow.lite.select.tf</b>
         */
        public TensorflowLiteSelectTfLibraryAccessors getTf() {
            return laccForTensorflowLiteSelectTfLibraryAccessors;
        }

    }

    public static class TensorflowLiteSelectTfLibraryAccessors extends SubDependencyFactory {

        public TensorflowLiteSelectTfLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ops</b> with <b>org.tensorflow:tensorflow-lite-select-tf-ops</b> coordinates and
         * with version reference <b>tensorflowLiteSelectTfOpsVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOps() {
            return create("tensorflow.lite.select.tf.ops");
        }

    }

    public static class VorbisjavaLibraryAccessors extends SubDependencyFactory {

        public VorbisjavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.gagravarr:vorbis-java-core</b> coordinates and
         * with version reference <b>vorbisjava</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("vorbisjava.core");
        }

    }

    public static class WavyLibraryAccessors extends SubDependencyFactory {

        public WavyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>slider</b> with <b>ir.mahozad.multiplatform:wavy-slider</b> coordinates and
         * with version reference <b>wavySlider</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSlider() {
            return create("wavy.slider");
        }

    }

    public static class WearLibraryAccessors extends SubDependencyFactory {
        private final WearComposeLibraryAccessors laccForWearComposeLibraryAccessors = new WearComposeLibraryAccessors(owner);

        public WearLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>wear.compose</b>
         */
        public WearComposeLibraryAccessors getCompose() {
            return laccForWearComposeLibraryAccessors;
        }

    }

    public static class WearComposeLibraryAccessors extends SubDependencyFactory {

        public WearComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>foundation</b> with <b>androidx.wear.compose:compose-foundation</b> coordinates and
         * with version reference <b>wearCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFoundation() {
            return create("wear.compose.foundation");
        }

        /**
         * Dependency provider for <b>material</b> with <b>androidx.wear.compose:compose-material</b> coordinates and
         * with version reference <b>wearCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() {
            return create("wear.compose.material");
        }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.wear.compose:compose-material3</b> coordinates and
         * with version reference <b>wearCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("wear.compose.material3");
        }

        /**
         * Dependency provider for <b>navigation</b> with <b>androidx.wear.compose:compose-navigation</b> coordinates and
         * with version reference <b>wearCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNavigation() {
            return create("wear.compose.navigation");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final CommonsVersionAccessors vaccForCommonsVersionAccessors = new CommonsVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        private final PytorchVersionAccessors vaccForPytorchVersionAccessors = new PytorchVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>accompanist</b> with value <b>0.37.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAccompanist() { return getVersion("accompanist"); }

        /**
         * Version alias <b>accompanistDrawablepainter</b> with value <b>0.37.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAccompanistDrawablepainter() { return getVersion("accompanistDrawablepainter"); }

        /**
         * Version alias <b>activityCompose</b> with value <b>1.13.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getActivityCompose() { return getVersion("activityCompose"); }

        /**
         * Version alias <b>agp</b> with value <b>8.7.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAgp() { return getVersion("agp"); }

        /**
         * Version alias <b>androidxTestCore</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAndroidxTestCore() { return getVersion("androidxTestCore"); }

        /**
         * Version alias <b>animation</b> with value <b>1.11.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnimation() { return getVersion("animation"); }

        /**
         * Version alias <b>app</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApp() { return getVersion("app"); }

        /**
         * Version alias <b>appcompat</b> with value <b>1.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppcompat() { return getVersion("appcompat"); }

        /**
         * Version alias <b>baselineprofile</b> with value <b>1.5.0-alpha06</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBaselineprofile() { return getVersion("baselineprofile"); }

        /**
         * Version alias <b>benchmarkMacroJunit4</b> with value <b>1.4.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBenchmarkMacroJunit4() { return getVersion("benchmarkMacroJunit4"); }

        /**
         * Version alias <b>bouncycastle</b> with value <b>1.84</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBouncycastle() { return getVersion("bouncycastle"); }

        /**
         * Version alias <b>capturable</b> with value <b>3.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCapturable() { return getVersion("capturable"); }

        /**
         * Version alias <b>checkerframework</b> with value <b>4.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCheckerframework() { return getVersion("checkerframework"); }

        /**
         * Version alias <b>codeview</b> with value <b>1.3.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCodeview() { return getVersion("codeview"); }

        /**
         * Version alias <b>coilCompose</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoilCompose() { return getVersion("coilCompose"); }

        /**
         * Version alias <b>composeBom</b> with value <b>2026.05.01</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeBom() { return getVersion("composeBom"); }

        /**
         * Version alias <b>composeDnd</b> with value <b>0.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeDnd() { return getVersion("composeDnd"); }

        /**
         * Version alias <b>composeMaterialIcons</b> with value <b>1.7.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeMaterialIcons() { return getVersion("composeMaterialIcons"); }

        /**
         * Version alias <b>composeMultiplatform</b> with value <b>1.6.10</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeMultiplatform() { return getVersion("composeMultiplatform"); }

        /**
         * Version alias <b>composeTesting</b> with value <b>1.0.0-alpha03</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeTesting() { return getVersion("composeTesting"); }

        /**
         * Version alias <b>composeUi</b> with value <b>1.11.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeUi() { return getVersion("composeUi"); }

        /**
         * Version alias <b>constraintlayoutCompose</b> with value <b>1.1.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConstraintlayoutCompose() { return getVersion("constraintlayoutCompose"); }

        /**
         * Version alias <b>coreKtx</b> with value <b>1.19.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreKtx() { return getVersion("coreKtx"); }

        /**
         * Version alias <b>coreSplashscreen</b> with value <b>1.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreSplashscreen() { return getVersion("coreSplashscreen"); }

        /**
         * Version alias <b>credentials</b> with value <b>1.6.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCredentials() { return getVersion("credentials"); }

        /**
         * Version alias <b>dagger</b> with value <b>2.59.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDagger() { return getVersion("dagger"); }

        /**
         * Version alias <b>datastore</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDatastore() { return getVersion("datastore"); }

        /**
         * Version alias <b>desugarJdkLibs</b> with value <b>2.1.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDesugarJdkLibs() { return getVersion("desugarJdkLibs"); }

        /**
         * Version alias <b>duktapeAndroid</b> with value <b>1.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDuktapeAndroid() { return getVersion("duktapeAndroid"); }

        /**
         * Version alias <b>espressoCore</b> with value <b>3.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEspressoCore() { return getVersion("espressoCore"); }

        /**
         * Version alias <b>foundation</b> with value <b>1.11.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFoundation() { return getVersion("foundation"); }

        /**
         * Version alias <b>fuel</b> with value <b>2.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFuel() { return getVersion("fuel"); }

        /**
         * Version alias <b>generativeai</b> with value <b>0.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGenerativeai() { return getVersion("generativeai"); }

        /**
         * Version alias <b>glance</b> with value <b>1.3.0-alpha01</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGlance() { return getVersion("glance"); }

        /**
         * Version alias <b>googleGenai</b> with value <b>1.57.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGoogleGenai() { return getVersion("googleGenai"); }

        /**
         * Version alias <b>googlePlayServicesCast</b> with value <b>22.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGooglePlayServicesCast() { return getVersion("googlePlayServicesCast"); }

        /**
         * Version alias <b>googleid</b> with value <b>1.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGoogleid() { return getVersion("googleid"); }

        /**
         * Version alias <b>graphicsShapes</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGraphicsShapes() { return getVersion("graphicsShapes"); }

        /**
         * Version alias <b>gson</b> with value <b>2.14.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGson() { return getVersion("gson"); }

        /**
         * Version alias <b>hiltAndroid</b> with value <b>2.59.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHiltAndroid() { return getVersion("hiltAndroid"); }

        /**
         * Version alias <b>hiltNavigationCompose</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHiltNavigationCompose() { return getVersion("hiltNavigationCompose"); }

        /**
         * Version alias <b>horologist</b> with value <b>0.7.15</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHorologist() { return getVersion("horologist"); }

        /**
         * Version alias <b>httpclient</b> with value <b>4.5.14</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHttpclient() { return getVersion("httpclient"); }

        /**
         * Version alias <b>jaudiotagger</b> with value <b>3.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJaudiotagger() { return getVersion("jaudiotagger"); }

        /**
         * Version alias <b>jdom2</b> with value <b>2.0.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJdom2() { return getVersion("jdom2"); }

        /**
         * Version alias <b>jose4j</b> with value <b>0.9.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJose4j() { return getVersion("jose4j"); }

        /**
         * Version alias <b>junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit"); }

        /**
         * Version alias <b>junit5</b> with value <b>6.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit5() { return getVersion("junit5"); }

        /**
         * Version alias <b>junitJupiter</b> with value <b>6.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunitJupiter() { return getVersion("junitJupiter"); }

        /**
         * Version alias <b>junitVersion</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunitVersion() { return getVersion("junitVersion"); }

        /**
         * Version alias <b>kotlin</b> with value <b>2.0.21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Version alias <b>kotlinxCollectionsImmutable</b> with value <b>0.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinxCollectionsImmutable() { return getVersion("kotlinxCollectionsImmutable"); }

        /**
         * Version alias <b>kotlinxDatetime</b> with value <b>0.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinxDatetime() { return getVersion("kotlinxDatetime"); }

        /**
         * Version alias <b>kotlinxSerializationJson</b> with value <b>1.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinxSerializationJson() { return getVersion("kotlinxSerializationJson"); }

        /**
         * Version alias <b>ksp</b> with value <b>2.3.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKsp() { return getVersion("ksp"); }

        /**
         * Version alias <b>ktor</b> with value <b>3.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKtor() { return getVersion("ktor"); }

        /**
         * Version alias <b>kuromoji</b> with value <b>0.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKuromoji() { return getVersion("kuromoji"); }

        /**
         * Version alias <b>lifecycleRuntimeKtx</b> with value <b>2.10.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleRuntimeKtx() { return getVersion("lifecycleRuntimeKtx"); }

        /**
         * Version alias <b>material</b> with value <b>1.14.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Version alias <b>material3</b> with value <b>1.5.0-alpha21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial3() { return getVersion("material3"); }

        /**
         * Version alias <b>media</b> with value <b>1.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMedia() { return getVersion("media"); }

        /**
         * Version alias <b>media3Session</b> with value <b>1.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMedia3Session() { return getVersion("media3Session"); }

        /**
         * Version alias <b>media3Transformer</b> with value <b>1.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMedia3Transformer() { return getVersion("media3Transformer"); }

        /**
         * Version alias <b>mediaRouter</b> with value <b>1.8.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMediaRouter() { return getVersion("mediaRouter"); }

        /**
         * Version alias <b>mediarouterVersion</b> with value <b>1.8.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMediarouterVersion() { return getVersion("mediarouterVersion"); }

        /**
         * Version alias <b>mockk</b> with value <b>1.14.11</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMockk() { return getVersion("mockk"); }

        /**
         * Version alias <b>navigationCompose</b> with value <b>2.9.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationCompose() { return getVersion("navigationCompose"); }

        /**
         * Version alias <b>navigationRuntimeKtx</b> with value <b>2.9.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationRuntimeKtx() { return getVersion("navigationRuntimeKtx"); }

        /**
         * Version alias <b>netty</b> with value <b>4.2.15.Final</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNetty() { return getVersion("netty"); }

        /**
         * Version alias <b>newpipeextractor</b> with value <b>v0.26.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNewpipeextractor() { return getVersion("newpipeextractor"); }

        /**
         * Version alias <b>okhttp</b> with value <b>5.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOkhttp() { return getVersion("okhttp"); }

        /**
         * Version alias <b>paging</b> with value <b>3.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPaging() { return getVersion("paging"); }

        /**
         * Version alias <b>pagingCommon</b> with value <b>3.3.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPagingCommon() { return getVersion("pagingCommon"); }

        /**
         * Version alias <b>paletteKtx</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPaletteKtx() { return getVersion("paletteKtx"); }

        /**
         * Version alias <b>pinyin4j</b> with value <b>2.5.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPinyin4j() { return getVersion("pinyin4j"); }

        /**
         * Version alias <b>playServicesCastFramework</b> with value <b>22.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlayServicesCastFramework() { return getVersion("playServicesCastFramework"); }

        /**
         * Version alias <b>playServicesWearable</b> with value <b>20.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlayServicesWearable() { return getVersion("playServicesWearable"); }

        /**
         * Version alias <b>profileinstaller</b> with value <b>1.4.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getProfileinstaller() { return getVersion("profileinstaller"); }

        /**
         * Version alias <b>protobufJavalite</b> with value <b>4.35.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getProtobufJavalite() { return getVersion("protobufJavalite"); }

        /**
         * Version alias <b>reorderable</b> with value <b>0.9.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getReorderable() { return getVersion("reorderable"); }

        /**
         * Version alias <b>reorderables</b> with value <b>3.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getReorderables() { return getVersion("reorderables"); }

        /**
         * Version alias <b>retrofit</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofit() { return getVersion("retrofit"); }

        /**
         * Version alias <b>roomCompiler</b> with value <b>2.8.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRoomCompiler() { return getVersion("roomCompiler"); }

        /**
         * Version alias <b>roomKtx</b> with value <b>2.8.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRoomKtx() { return getVersion("roomKtx"); }

        /**
         * Version alias <b>roomRuntime</b> with value <b>2.8.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRoomRuntime() { return getVersion("roomRuntime"); }

        /**
         * Version alias <b>securityCrypto</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSecurityCrypto() { return getVersion("securityCrypto"); }

        /**
         * Version alias <b>smoothCornerRectAndroidCompose</b> with value <b>v1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSmoothCornerRectAndroidCompose() { return getVersion("smoothCornerRectAndroidCompose"); }

        /**
         * Version alias <b>spleeterAndroidIos</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSpleeterAndroidIos() { return getVersion("spleeterAndroidIos"); }

        /**
         * Version alias <b>taglib</b> with value <b>1.0.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTaglib() { return getVersion("taglib"); }

        /**
         * Version alias <b>tensorflowLite</b> with value <b>2.17.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTensorflowLite() { return getVersion("tensorflowLite"); }

        /**
         * Version alias <b>tensorflowLiteSelectTfOps</b> with value <b>2.16.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTensorflowLiteSelectTfOps() { return getVersion("tensorflowLiteSelectTfOps"); }

        /**
         * Version alias <b>tensorflowLiteSelectTfOpsVersion</b> with value <b>2.16.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTensorflowLiteSelectTfOpsVersion() { return getVersion("tensorflowLiteSelectTfOpsVersion"); }

        /**
         * Version alias <b>tensorflowLiteSupport</b> with value <b>0.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTensorflowLiteSupport() { return getVersion("tensorflowLiteSupport"); }

        /**
         * Version alias <b>timber</b> with value <b>5.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTimber() { return getVersion("timber"); }

        /**
         * Version alias <b>truth</b> with value <b>1.4.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTruth() { return getVersion("truth"); }

        /**
         * Version alias <b>turbine</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTurbine() { return getVersion("turbine"); }

        /**
         * Version alias <b>uiautomator</b> with value <b>2.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUiautomator() { return getVersion("uiautomator"); }

        /**
         * Version alias <b>vorbisjava</b> with value <b>0.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getVorbisjava() { return getVersion("vorbisjava"); }

        /**
         * Version alias <b>wavySlider</b> with value <b>2.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWavySlider() { return getVersion("wavySlider"); }

        /**
         * Version alias <b>wearCompose</b> with value <b>1.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWearCompose() { return getVersion("wearCompose"); }

        /**
         * Version alias <b>workRuntimeKtx</b> with value <b>2.11.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWorkRuntimeKtx() { return getVersion("workRuntimeKtx"); }

        /**
         * Group of versions at <b>versions.commons</b>
         */
        public CommonsVersionAccessors getCommons() {
            return vaccForCommonsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.javax</b>
         */
        public JavaxVersionAccessors getJavax() {
            return vaccForJavaxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlinx</b>
         */
        public KotlinxVersionAccessors getKotlinx() {
            return vaccForKotlinxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.pytorch</b>
         */
        public PytorchVersionAccessors getPytorch() {
            return vaccForPytorchVersionAccessors;
        }

    }

    public static class CommonsVersionAccessors extends VersionFactory  {

        public CommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>commons.lang3</b> with value <b>3.20.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLang3() { return getVersion("commons.lang3"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>javax.inject</b> with value <b>1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getInject() { return getVersion("javax.inject"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlinx.coroutines</b> with value <b>1.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoroutines() { return getVersion("kotlinx.coroutines"); }

    }

    public static class PytorchVersionAccessors extends VersionFactory  {

        private final PytorchAndroidVersionAccessors vaccForPytorchAndroidVersionAccessors = new PytorchAndroidVersionAccessors(providers, config);
        public PytorchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.pytorch.android</b>
         */
        public PytorchAndroidVersionAccessors getAndroid() {
            return vaccForPytorchAndroidVersionAccessors;
        }

    }

    public static class PytorchAndroidVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public PytorchAndroidVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>pytorch.android</b> with value <b>2.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("pytorch.android"); }

        /**
         * Version alias <b>pytorch.android.torchvision</b> with value <b>2.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTorchvision() { return getVersion("pytorch.android.torchvision"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final ComposePluginAccessors paccForComposePluginAccessors = new ComposePluginAccessors(providers, config);
        private final DaggerPluginAccessors paccForDaggerPluginAccessors = new DaggerPluginAccessors(providers, config);
        private final JetbrainsPluginAccessors paccForJetbrainsPluginAccessors = new JetbrainsPluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>baselineprofile</b> with plugin id <b>androidx.baselineprofile</b> and
         * with version reference <b>baselineprofile</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getBaselineprofile() { return createPlugin("baselineprofile"); }

        /**
         * Plugin provider for <b>ksp</b> with plugin id <b>com.google.devtools.ksp</b> and
         * with version reference <b>ksp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKsp() { return createPlugin("ksp"); }

        /**
         * Group of plugins at <b>plugins.android</b>
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.compose</b>
         */
        public ComposePluginAccessors getCompose() {
            return paccForComposePluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.dagger</b>
         */
        public DaggerPluginAccessors getDagger() {
            return paccForDaggerPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.jetbrains</b>
         */
        public JetbrainsPluginAccessors getJetbrains() {
            return paccForJetbrainsPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.kotlin</b>
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>android.application</b> with plugin id <b>com.android.application</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

        /**
         * Plugin provider for <b>android.library</b> with plugin id <b>com.android.library</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getLibrary() { return createPlugin("android.library"); }

        /**
         * Plugin provider for <b>android.test</b> with plugin id <b>com.android.test</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getTest() { return createPlugin("android.test"); }

    }

    public static class ComposePluginAccessors extends PluginFactory {

        public ComposePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>compose.compiler</b> with plugin id <b>org.jetbrains.kotlin.plugin.compose</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getCompiler() { return createPlugin("compose.compiler"); }

        /**
         * Plugin provider for <b>compose.multiplatform</b> with plugin id <b>org.jetbrains.kotlin.plugin.compose.multiplatform</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getMultiplatform() { return createPlugin("compose.multiplatform"); }

    }

    public static class DaggerPluginAccessors extends PluginFactory {
        private final DaggerHiltPluginAccessors paccForDaggerHiltPluginAccessors = new DaggerHiltPluginAccessors(providers, config);

        public DaggerPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.dagger.hilt</b>
         */
        public DaggerHiltPluginAccessors getHilt() {
            return paccForDaggerHiltPluginAccessors;
        }

    }

    public static class DaggerHiltPluginAccessors extends PluginFactory {

        public DaggerHiltPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>dagger.hilt.android</b> with plugin id <b>com.google.dagger.hilt.android</b> and
         * with version reference <b>dagger</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("dagger.hilt.android"); }

    }

    public static class JetbrainsPluginAccessors extends PluginFactory {
        private final JetbrainsKotlinPluginAccessors paccForJetbrainsKotlinPluginAccessors = new JetbrainsKotlinPluginAccessors(providers, config);

        public JetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.jetbrains.kotlin</b>
         */
        public JetbrainsKotlinPluginAccessors getKotlin() {
            return paccForJetbrainsKotlinPluginAccessors;
        }

    }

    public static class JetbrainsKotlinPluginAccessors extends PluginFactory {

        public JetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>jetbrains.kotlin.android</b> with plugin id <b>org.jetbrains.kotlin.android</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("jetbrains.kotlin.android"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlin.jvm</b> with plugin id <b>org.jetbrains.kotlin.jvm</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getJvm() { return createPlugin("kotlin.jvm"); }

        /**
         * Plugin provider for <b>kotlin.multiplatform</b> with plugin id <b>org.jetbrains.kotlin.multiplatform</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getMultiplatform() { return createPlugin("kotlin.multiplatform"); }

        /**
         * Plugin provider for <b>kotlin.serialization</b> with plugin id <b>org.jetbrains.kotlin.plugin.serialization</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getSerialization() { return createPlugin("kotlin.serialization"); }

    }

}
