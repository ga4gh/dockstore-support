package io.dockstore.tooltester.blacklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * These are Tool IDs and ToolVersion names that are known to always fail on the latest Dockstore CLI
 * @author gluu
 * @since 04/04/19
 */
public class BlackList {
    /**
     * Determines whether an entry and its version has been blacklisted or not
     * @param entryId   The entry's ID (e.g. #workflow/github.com/dockstore/hello_world)
     * @param version   The entry's version name (e.g. master)
     * @return
     */
    public static boolean isNotBlacklisted(String entryId, String version) {
        boolean blacklisted = BlackList.BLACKLIST.stream()
                .anyMatch(object -> object.getToolId().equals(entryId) && object.getToolVersionName().equals(version));
        return blacklisted;
    }

    private static final List<BlackListObject> BLACKLIST = Collections.unmodifiableList(
            new ArrayList<BlackListObject>() {{
                add(new BlackListObject("#workflow/github.com/DataBiosphere/topmed-workflows/UM_variant_caller_wdl", "1.29.0",  "doesn't work"));
                add(new BlackListObject("#workflow/github.com/DataBiosphere/topmed-workflows/UM_aligner_wdl", "1.29.0", "doesn't work"));
                add(new BlackListObject("#workflow/github.com/DataBiosphere/topmed-workflows/UM_aligner_cwl", "1.31.0", "doesn't work"));
                add(new BlackListObject("quay.io/pancancer/pcawg-sanger-cgp-workflow", "2.0.2", "/var/spool/cwl"));
                add(new BlackListObject("quay.io/pancancer/pcawg-sanger-cgp-workflow", "2.0.3", "/var/spool/cwl"));
                add(new BlackListObject("quay.io/pancancer/pcawg-bwa-mem-workflow", "2.6.8_1.2", "/var/spool/cwl"));
                add(new BlackListObject("quay.io/pancancer/pcawg-bwa-mem-workflow", "checker", "/var/spool/cwl"));
                add(new BlackListObject("quay.io/pancancer/pcawg-dkfz-workflow", "2.0.1_cwl1.0", "/var/spool/cwl"));
                add(new BlackListObject("quay.io/pancancer/pcawg_delly_workflow", "2.0.0-cwl1.0", "/var/spool/cwl"));
                add(new BlackListObject("quay.io/pancancer/pcawg_delly_workflow", "2.0.1-cwl1.0", "/var/spool/cwl"));
                add(new BlackListObject("#workflow/github.com/KnowEnG/cwl-gene-prioritization", "master", "master branch banned"));
                add(new BlackListObject("#workflow/github.com/NCI-GDC/gdc-dnaseq-cwl/GDC_DNASeq", "master", "doesn't work, master branch banned"));
                add(new BlackListObject("#workflow/github.com/bcbio/bcbio_validation_workflows", "master", "doesn't work, master branch banned"));
                add(new BlackListObject("#workflow/github.com/bcbio/bcbio_validation_workflows/wes-agha-test-arvados", "master", "doesn't work, master branch banned"));
                add(new BlackListObject("#workflow/github.com/dockstore-testing/md5sum-checker", "develop", "input file not relative to parameter file, develop branch banned"));
                add(new BlackListObject("#workflow/github.com/dockstore-testing/md5sum-checker/wdl", "develop", "input file not relative to parameter file, develop branch banned"));
                add(new BlackListObject("#workflow/github.com/Barski-lab/ga4gh_challenge", "master", "master branch banned"));
                add(new BlackListObject("#workflow/github.com/dockstore/hello_world", "master", "master branch banned"));
            }});
}
