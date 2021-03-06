package org.broadinstitute.hellbender.tools.walkers.sv;

import org.broadinstitute.hellbender.CommandLineProgramTest;
import org.broadinstitute.hellbender.testutils.IntegrationTestSpec;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PairedEndAndSplitReadEvidenceCollectionIntegrationTest extends CommandLineProgramTest {

    public static final String pesrTestDir = toolsTestDir + "walkers/sv/pesr";

    @Test
    public void testPESRCollection() throws Exception {
        // these test files were generated by svtk collect-pesr
        IntegrationTestSpec spec = new IntegrationTestSpec(
                "-I " + NA12878_20_21_WGS_bam + " --sample-name NA12878 -PE %s -SR %s",
                Arrays.asList(pesrTestDir + "/NA12878.disc.txt.gz", pesrTestDir + "/NA12878.split.txt.gz"));
        spec.executeTest("base PESR collection", this);
    }

}